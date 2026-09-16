import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

# --------------------------------------------------
# STEP 1: Create / Load Dataset
# --------------------------------------------------

# For your own CSV file, use:
# df = pd.read_csv("your_dataset.csv")

data = {
    "Name": ["Arun", "Bala", "Chitra", "David", "Ezhil"],
    "Age": [20, 21, 19, 22, 20],
    "Mark": [78, 85, 67, 90, 75]
}

df = pd.DataFrame(data)

# --------------------------------------------------
# STEP 2: Display Dataset
# --------------------------------------------------

print("Dataset:")
print(df)

# --------------------------------------------------
# STEP 3: Pandas Operations
# --------------------------------------------------

print("\nFirst 5 Rows:")
print(df.head())

print("\nDataset Information:")
print(df.info())

print("\nStatistical Description:")
print(df.describe())

print("\nColumn Names:")
print(df.columns)

print("\nMissing Values:")
print(df.isnull().sum())

# --------------------------------------------------
# STEP 4: NumPy Operations
# --------------------------------------------------

marks = np.array(df["Mark"])

print("\nNumPy Array:")
print(marks)

print("Maximum Mark:", np.max(marks))
print("Minimum Mark:", np.min(marks))
print("Average Mark:", np.mean(marks))
print("Standard Deviation:", np.std(marks))

# --------------------------------------------------
# STEP 5: Matplotlib Visualization
# --------------------------------------------------

plt.figure(figsize=(8, 5))

plt.bar(df["Name"], df["Mark"])

plt.xlabel("Students")
plt.ylabel("Marks")
plt.title("Student Mark Analysis")

plt.show()
