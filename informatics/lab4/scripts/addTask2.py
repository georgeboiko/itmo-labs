import sys, re

def invert(a):
    return 1 if a == 0 else 0

def validate(s, f):
    if f == 0:
        r = r"true|false|null|((-){0,1}(([1-9]\d{0,})|0)(\.\d+){0,}((e|E)(\+|\-)(\d+)){0,1})"
        rT = r"([1-9]\d\d\d-((0[1-9])|([1][0-2]))-(([0][1-9])|([1-2]\d)|([3][0-1])))"
        if re.fullmatch(rT, s) != None: return '\'' + s + '\''
        return s if re.fullmatch(r, s) == None else '\'' + s + '\''
    if f:
        if '.' in s:
            s1 = s.split('.')
            while len(s1[1]) > 1 and s1[1][-1] == '0': s1[1] = s1[1][:-1]
            return s1[0] + '.' + s1[1]
        return s


def convertWithRegex(data, inName=0, wasD=0, level=-1):
    result = ""
    space = "  "
    last = ""
    inStupidVal = 0
    q = [0]
    curValOfName = ""
    while '\n' in data: data = data.replace('\n', '')
    for elem in data:
        if elem == '\"':
            inName = invert(inName)
            if inName == 0:
                result += validate(curValOfName, 0)
                curValOfName = ""
                if wasD == 1: wasD = 0
            if inName == 1 and wasD: result += ' '
            continue
        elif last+elem in ['[]', r'{}']:
            result += ' ' + last+elem
            if last == '[': q.pop()
            if last == '{': level -= 1
            last = elem
            continue
        elif last == ':' and inName == 0 and (not(elem in [' ', '{', '['])):
            inName = 1
            result += ' '
            last = elem
            inStupidVal = 1
        elif last in [',', '['] and inName == 0 and (not(elem in [' ', '{', '['])):
            inName = 1
            result += '\n' + space*(level) + "- "
            last = elem
            inStupidVal = 1
        elif elem in [',', '}', ']'] and inStupidVal:
            if elem == '}':
                level -= 1
                if len(q) > 0: q.pop()
            if elem == ']': q.pop()
            inStupidVal = 0
            inName = 0
            result += validate(curValOfName, 1)
            curValOfName = ""
            if wasD == 1: wasD = 0
            last = elem
            continue
        if inName:
            if last in ['{', '[', ',']:
                if result[-2:] != '- ' and wasD == 0:
                    if q[-1] == 0: result += '\n' + space*level
                    else: result += '\n' + space*(level) + '- '
            last = elem
            if inStupidVal == 0 or (inStupidVal == 1 and elem != ' '): curValOfName += elem
            continue
        if elem == '[':
            wasD = 0
            q.append(1)
        if elem == ']': q.pop()
        if elem == ':':
            result += elem
            wasD = 1
        if elem == '{':
            wasD = 0
            level += 1
            if len(q) > 0 and q[-1] == 1: result += '\n' + space*(level-1) + "- "
            q.append(0)
        if elem == '}':
            level -= 1
            if len(q) > 0: q.pop()
        if elem != ' ': last = elem
    return result[1:]

if __name__ == "__main__":
    name = sys.argv[1] if len(sys.argv) > 1 else input()
    data = open('./input/' + name + '.json').read()
    yaml_output = convertWithRegex(data)
    if len(sys.argv) > 2: name += 'from'+sys.argv[2]
    f = open('output/'+name + '.yaml', 'w')
    f.write(yaml_output)
    f.close()