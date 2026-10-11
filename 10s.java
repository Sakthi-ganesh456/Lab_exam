import matplotlib.pyplot as plt
import seaborn as sns
import pandas as pd
from sklearn.datasets import load_iris
iris = load_iris()
df = pd.DataFrame(iris.data, columns=iris.feature_names)
df['Species'] = iris.target
plt.figure(figsize=(6, 4))
sns.scatterplot(data=df, x='sepal length (cm)', y='sepal width (cm)', hue='Species', palette='viridis')
plt.title("Iris Scatter Plot")
plt.show()
plt.figure(figsize=(6, 4))
sns.boxplot(data=df, x='Species', y='petal length (cm)')
plt.title("Petal Length by Species")
plt.show()
plt.figure(figsize=(6, 4))
sns.histplot(data=df, x='sepal length (cm)', hue='Species', kde=True)
plt.title("Sepal Length Distribution")
plt.show()

  import matplotlib.pyplot as plt
import seaborn as sns
df = sns.load_dataset('titanic')
plt.figure(figsize=(6, 4))
sns.countplot(data=df, x='survived', hue='survived')
plt.title("Survival Count")
plt.show()
plt.figure(figsize=(6, 4))
sns.countplot(data=df, x='class', hue='survived')
plt.title("Survival by Passenger Class")
plt.show()
plt.figure(figsize=(6, 4))
sns.histplot(data=df, x='age', hue='survived', bins=20, kde=True)
plt.title("Age Distribution by Survival")
plt.show()

  #Visualization Customer Sales
import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns
df = pd.DataFrame({
'Customer': ['A', 'B', 'C', 'D', 'E'],
'Sales': [5000, 7000, 3000, 9000, 6000],
'Profit': [1000, 2000, 500, 3000, 1500],
'Orders': [5, 7, 3, 9, 6]
})
plt.figure(figsize=(6, 4))
plt.bar(df['Customer'], df['Sales'])
plt.title("Sales by Customer")
plt.xlabel("Customer")
plt.ylabel("Sales")
plt.show()
plt.figure(figsize=(6, 4))
plt.plot(df['Customer'], df['Profit'], marker='o')
plt.title("Profit by Customer")
plt.xlabel("Customer")
plt.ylabel("Profit")
plt.show()
plt.figure(figsize=(6, 4))
sns.scatterplot(data=df, x='Orders', y='Sales', hue='Customer', s=150)
plt.title("Orders vs Sales")
plt.show()
