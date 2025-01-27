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

def stupidConvertToCsv(f):
    data = {}
    for ind in range(len(f)):
        s = correct(f[ind])
        if not(s[0] in ['{', '}', '[', ']', 'schedule']):
            if data.get(s[0], -1) == -1: data[s[0]] = [s[1]]
            else: data[s[0]].append(s[1])
    csv = ""
    for key, val in data.items(): csv += key + ','
    csv = csv[:-1] + '\n'
    for i in range(len(data['name'])):
        for key, val in data.items():
            csv += val[i] + ','
        csv = csv[:-1] + '\n'
    return csv[:-1]

data = open('input/in.json').readlines()
f = open('output/in.csv', 'w')
f.write(stupidConvertToCsv(data))
f.close()