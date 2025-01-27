import time
from task1 import stupidConvertToYaml
from addTask1 import convertWithLib
from addTask2 import convertWithRegex
from addTask3 import Json
import numpy
import seaborn as sns
import matplotlib.pyplot as plt
import pandas as pd

def get(f, data):
    a = []
    for i in range(100):
        startTime = time.time()
        f(data)
        a.append(time.time() - startTime)
    df = pd.DataFrame(a)

    sns.histplot(data=df)
    plt.title("Histogram " + str(f.__name__))
    plt.show()

    sns.histplot(data=df, cumulative=True, element="poly", fill=False)
    plt.title("Cumulative distribution function " + str(f.__name__))
    plt.show()

    return numpy.median(a)

dataRead = open('input/in.json').read()
dataReadLines = open('input/in.json').readlines()

print("Stupid convert only for in.json: " + str(get(stupidConvertToYaml, dataReadLines)))
data = open('input/in.json')
print("Convert with yaml.dump: " + str(get(convertWithLib, dataRead)))
data = open('input/in.json')
print("Convert with Regex: " + str(get(convertWithRegex, dataRead)))
data = open('input/in.json')
print("Convert with grammar: " + str(get(Json(dataRead).convert, "yaml")))  