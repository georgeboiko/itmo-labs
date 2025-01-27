def correct(s):
    while '\n' in s: 
        s = s.replace('\n', '')
    s = s.split(':')
    while '' in s: s.remove('')
    for i in range(len(s)): 
        s[i] = s[i].strip()
        s[i] = s[i].strip(",")
        s[i] = s[i].strip("\"")
    return s

def stupidConvertToYaml(f):
    level = -1
    inArr = 0
    yaml = ""
    for ind in range(len(f)):
        s = correct(f[ind])
        output = ""
        isFirst = 1
        for i in s:
            if i == '{': level += 1
            elif i == '}': level -= 1
            elif i == '[': inArr = 1
            elif i == ']': inArr = 0
            elif not(i in ['[', ']']):
                if isFirst:
                    if inArr and correct(f[max(ind-1, 0)]) == ['{']: output += (' '*4*(level-1) + '  - ' + i + ':')
                    else: output += (' '*4*level + i + ':')
                    isFirst = 0
                else:
                    output += (' \'' + i + '\'')
        if output != "": yaml += output + '\n'
    return yaml[:-1]

data = open('input/in.json').readlines()
f = open('output/in.yaml', 'w')
f.write(stupidConvertToYaml(data))
f.close()
