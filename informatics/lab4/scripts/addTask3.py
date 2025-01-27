import sys, re

class Json:
    def __init__(self, inputStr: str):
        string = inputStr
        while '\n' in string: string = string.replace('\n', '')
        self.val = Value(string)
    def parse(self):
        result = self.val.parse()
        if result == None: return "isn't correct JSON string"
        return result[0]
    def validate(self, s):
        if s == None: return "null"
        if isinstance(s, bool) and s == True: return "true"
        if isinstance(s, bool) and s == False: return "false"
        s1 = str(s)
        r = r"true|false|null|((-){0,1}(([1-9]\d{0,})|0)(\.\d+){0,}((e|E)(\+|\-)(\d+)){0,1})"
        rT = r"([1-9]\d\d\d-((0[1-9])|([1][0-2]))-(([0][1-9])|([1-2]\d)|([3][0-1])))"
        if re.fullmatch(rT, s1) != None: return '\'' + s1 + '\''
        return '\'' + s1 + '\'' if re.fullmatch(r, s1) != None and isinstance(s, str) else s1
    def convertToYaml(self, level=0, data=None, needDash=0):
        if data == None: data = self.parse()
        yaml = ""
        space = "  "
        if isinstance(data, dict):
            for key, val in data.items():
                if needDash:
                    yaml += space*(level-1) + "- "
                    needDash = 0
                else: yaml += space*level
                yaml += key + ":"
                if isinstance(val, dict):
                    if val != {}: yaml += "\n" +  self.convertToYaml(level+1, val)
                    else: yaml += " {}\n"
                elif isinstance(val, list):
                    if val != []: yaml += "\n" +  self.convertToYaml(level+1, val)
                    else: yaml += " []\n"
                else: yaml += " " + self.validate(val) + "\n"
        elif isinstance(data, list):
            for val in data:
                if isinstance(val, dict):
                    if val != {}: yaml += self.convertToYaml(level, val, 1)
                    else: yaml += " {}\n"
                elif isinstance(val, list):
                    if val != []: yaml += self.convertToYaml(level, val, 1)
                    else: yaml += " []\n"
                else: yaml += space*(level-1) + "- " + self.validate(val) + "\n"
        return yaml
    def convert(self, to):
        if to == "yaml": return self.convertToYaml().strip("\n")
        
class Bool:
    def __init__(self, inputStr: str):
        self.val = inputStr
    def parse(self):
        if self.val.startswith("true"): return True, self.val[4:].strip()
        if self.val.startswith("false"): return False, self.val[5:].strip()

class Null:
    def __init__(self, inputStr: str):
        self.val = inputStr
    def parse(self):
        if self.val.startswith("null"): return None, self.val[4:].strip()

class Number:
    def __init__(self, inputStr: str):
        self.val = inputStr
        self.alphabet = '0123456789.Ee-+'
        self.intRegex = re.compile(r"((-){0,1}(([1-9]\d{0,})|0))")
        self.floatRegex = re.compile(r"((-){0,1}(([1-9]\d{0,})|0)(\.\d+)((e|E)(\+|\-)(\d+)){0,1})")
    def parse(self):
        result = ""
        for char in self.val:
            if not(char in self.alphabet): break
            result += char
        if self.intRegex.fullmatch(result) != None: return int(result), self.val[len(result):].strip()
        if self.floatRegex.fullmatch(result) != None: return float(result), self.val[len(result):].strip()
    
class String:
    def __init__(self, inputStr: str):
        self.val = inputStr
    def parse(self):
        if self.val[0] != "\"": return None
        posOfSecondQuote = self.val.find("\"", 1)
        if posOfSecondQuote == -1: return None
        return self.val[1:posOfSecondQuote], self.val[(posOfSecondQuote+1):].strip()
    
class Values:
    def __init__(self, inputStr: str):
        self.val = inputStr
        self.uselessVal = None
    def parse(self, curVal=None, result=None):
        if curVal == None:
            curVal = self.val
            result = []
        parsedValue = Value(curVal).parse()
        if parsedValue == None: return None
        result.append(parsedValue[0])
        if parsedValue[1] != None and len(parsedValue[1]) != 0:
            if parsedValue[1][0] != ",":
                self.uselessVal = parsedValue[1].strip()
                return result, self.uselessVal
            self.parse(parsedValue[1][1:].strip(), result)
        return result, self.uselessVal
    
class S_Values:
    def __init__(self, inputStr: str):
        self.val = inputStr
        self.uselessVal = None
    def parse(self, curVal=None, result=None):
        if curVal == None:
            curVal = self.val
            result = {}
        parsedData = String(curVal).parse()
        if parsedData == None: return None
        parsedKey = parsedData[0]
        if len(parsedData[1]) < 2 or parsedData[1][0] != ':': return None
        parsedValue = Value(parsedData[1][1:].strip()).parse()
        if parsedValue == None: return None
        result[parsedKey] = parsedValue[0]
        if parsedValue[1] != None and len(parsedValue[1]) != 0:
            if parsedValue[1][0] != ',':
                self.uselessVal = parsedValue[1].strip()
                return result, self.uselessVal
            self.parse(parsedValue[1][1:].strip(), result)
        return result, self.uselessVal

class Array:
    def __init__(self, inputStr: str):
        self.val = inputStr
    def parse(self):
        if self.val[0] != '[': return None
        if self.val[1:].strip().startswith("]"): return [], self.val[(self.val.find("]", 1)+1):].strip()
        parsedValue = Values(self.val[1:].strip()).parse()
        if parsedValue == None: return None
        if parsedValue[1] != None and parsedValue[1][0] != ']': return None
        return parsedValue[0], (parsedValue[1][1:].strip() if parsedValue[1] != None else None)
    
class Object:
    def __init__(self, inputStr: str):
        self.val = inputStr
    def parse(self):
        if self.val[0] != '{': return None
        if self.val[1:].strip().startswith("}"): return {}, self.val[(self.val.find("}", 1)+1):].strip()
        parsedValue = S_Values(self.val[1:].strip()).parse()
        if parsedValue == None: return None
        if parsedValue[1] != None and parsedValue[1][0] != '}': return None
        return parsedValue[0], (parsedValue[1][1:].strip() if parsedValue[1] != None else None)
        
class Value:
    def __init__(self, inputStr):
        self.val = inputStr
    def parse(self):
        if String(self.val).parse() != None: return String(self.val).parse()
        if Number(self.val).parse() != None: return Number(self.val).parse()
        if Bool(self.val).parse() != None: return Bool(self.val).parse()
        if Null(self.val).parse() != None: return Null(self.val).parse()
        if Array(self.val).parse() != None: return Array(self.val).parse()
        if Object(self.val).parse() != None: return Object(self.val).parse()

if __name__ == "__main__":
    name = sys.argv[1] if len(sys.argv) > 1 else input()
    data = open('./input/' + name + '.json').read()
    if len(sys.argv) > 2: name += 'from'+sys.argv[2]
    f = open('output/'+name + '.yaml', 'w')
    f.write(Json(data).convert("yaml"))
    f.close()