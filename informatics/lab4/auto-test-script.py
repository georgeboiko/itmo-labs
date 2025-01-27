import os

tests = ['in']
for i in range(1, 21): tests.append('test'+str(i))

for name in tests:
    os.system('python3 scripts/addTask1.py ' + name + ' 1')
    os.system('python3 scripts/addTask3.py ' + name + ' 3')

    res1 = open('output/' + name + 'from1.yaml').read()
    res2 = open('output/' + name + 'from3.yaml').read()
    if res1 == res2:
        print(name+': OK')
        os.remove('output/' + name + 'from1.yaml')
        os.remove('output/' + name + 'from3.yaml')
    else: print(name+': ERROR')