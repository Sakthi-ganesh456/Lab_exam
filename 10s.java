# Program 3: Iris Data Exploration and Visualization

import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

from sklearn.datasets import load_iris

# --------------------------------------------------
# STEP 1: Load Iris Dataset
# --------------------------------------------------

iris = load_iris()

df = pd.DataFrame(
    iris.data,
    columns=iris.feature_names
)

df["Species"] = iris.target

# Convert numerical target into species names

df["Species"] = df["Species"].map({
    0: "Setosa",
    1: "Versicolor",
    2: "Virginica"
})

# --------------------------------------------------
# STEP 2: Display Dataset
# --------------------------------------------------

print("First Five Records:")
print(df.head())

print("\nDataset Shape:")
print(df.shape)

print("\nColumn Names:")
print(df.columns)

print("\nStatistical Description:")
print(df.describe())

print("\nSpecies Count:")
print(df["Species"].value_counts())

print("\nMissing Values:")
print(df.isnull().sum())

# --------------------------------------------------
# STEP 3: Scatter Plot
# --------------------------------------------------

plt.figure(figsize=(8, 6))

sns.scatterplot(
    data=df,
    x="sepal length (cm)",
    y="sepal width (cm)",
    hue="Species"
)

plt.title("Iris Sepal Length vs Sepal Width")
plt.show()

# --------------------------------------------------
# STEP 4: Petal Visualization
# --------------------------------------------------

plt.figure(figsize=(8, 6))

sns.scatterplot(
    data=df,
    x="petal length (cm)",
    y="petal width (cm)",
    hue="Species"
)

plt.title("Iris Petal Length vs Petal Width")
plt.show()

# --------------------------------------------------
# STEP 5: Histogram
# --------------------------------------------------

df.hist(figsize=(10, 8))

plt.suptitle("Iris Dataset Feature Distribution")

plt.show()

# --------------------------------------------------
# STEP 6: Box Plot
# --------------------------------------------------

plt.figure(figsize=(10, 6))

sns.boxplot(data=df.drop(columns=["Species"]))

plt.title("Iris Feature Box Plot")

plt.xticks(rotation=20)

plt.show()

# --------------------------------------------------
# STEP 7: Correlation Heatmap
# --------------------------------------------------

plt.figure(figsize=(8, 6))

correlation = df.drop(columns=["Species"]).corr()

sns.heatmap(
    correlation,
    annot=True,
    cmap="coolwarm"
)

plt.title("Feature Correlation")

plt.show()
