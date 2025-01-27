import json, yaml, sys

def convertWithLib(data):
    return yaml.dump(json.loads(data), allow_unicode=True, sort_keys=False)[:-1]

if __name__ == "__main__":
    name = sys.argv[1] if len(sys.argv) > 1 else input()
    data = open('./input/' + name + '.json').read()
    if len(sys.argv) > 2: name += 'from'+sys.argv[2]
    f = open('output/'+name + '.yaml', 'w')
    f.write(convertWithLib(data))
    f.close()