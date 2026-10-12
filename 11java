import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.naive_bayes import GaussianNB
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix
data = pd.DataFrame({
'Age': [22, 25, 47, 52, 46, 56, 23, 40, 60, 35],
'Salary': [20000, 25000, 80000, 90000, 75000, 95000, 22000, 60000, 100000, 50000],
'Purchased': [0, 0, 1, 1, 1, 1, 0, 1, 1, 0]
})
X = data[['Age', 'Salary']]
y = data['Purchased']
X_train, X_test, y_train, y_test = train_test_split(
X, y, test_size=0.2, random_state=42
)
model = GaussianNB()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)
print("Accuracy:", accuracy_score(y_test, y_pred))
print("Prediction:", model.predict([[30, 40000]])[0])
# Visualization 1: Scatter Plot of Features
plt.figure(figsize=(6, 4))
sns.scatterplot(data=data, x='Age', y='Salary', hue='Purchased', palette='coolwarm', s=100)
plt.title("Social Network: Age vs Salary")
plt.show()
# Visualization 2: Feature Distributions
fig, axes = plt.subplots(1, 2, figsize=(12, 4))
sns.boxplot(ax=axes[0], data=data, x='Purchased', y='Age', palette='Set2')
axes[0].set_title("Age Distribution by Purchase Decision")
sns.boxplot(ax=axes[1], data=data, x='Purchased', y='Salary', palette='Set2')
axes[1].set_title("Salary Distribution by Purchase Decision")
plt.tight_layout()
plt.show()
