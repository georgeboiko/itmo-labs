import pandas as pd
import matplotlib.pyplot as plt


def get(date, column, a):
    column = a[column]
    res = []
    for i in range(len(a)):
        if a['Дата'][i] == date: res.append(column[i])
    return res

a = pd.read_excel('./dataForPy.xlsx')

dt = []
for x in ['18/09/18', '18/10/18', '20/11/18', '18/12/18']:
    for y in ['Открытие', 'Максимум', 'Минимум', 'Закрытие']:
        dt.append(get(x, y, a))

lb = []
for x in ['18/09/18', '18/10/18', '20/11/18', '18/12/18']:
    for y in ['Открытие', 'Максимум', 'Минимум', 'Закрытие']:
        lb.append(x + '\n' + y)

plt.boxplot(dt, showmeans=True, labels=lb)
plt.show()
