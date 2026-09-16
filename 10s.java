# Program 2: Data Preprocessing

import pandas as pd
import numpy as np

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler, LabelEncoder

# --------------------------------------------------
# STEP 1: Create Dataset
# --------------------------------------------------

data = {
    "Age": [20, 21, np.nan, 25, 23, 21, 20],
    "Salary": [25000, 30000, 35000, np.nan, 40000, 30000, 25000],
    "City": ["Trichy", "Chennai", "Madurai", "Trichy",
             "Chennai", "Chennai", "Trichy"],
    "Purchased": ["No", "Yes", "Yes", "Yes",
                  "Yes", "Yes", "No"]
}

df = pd.DataFrame(data)

print("Original Dataset:")
print(df)

# --------------------------------------------------
# STEP 2: Check Missing Values
# --------------------------------------------------

print("\nMissing Values:")
print(df.isnull().sum())

# --------------------------------------------------
# STEP 3: Fill Missing Numerical Values
# --------------------------------------------------

df["Age"] = df["Age"].fillna(df["Age"].mean())
df["Salary"] = df["Salary"].fillna(df["Salary"].mean())

# --------------------------------------------------
# STEP 4: Remove Duplicate Rows
# --------------------------------------------------

df = df.drop_duplicates()

print("\nAfter Removing Duplicates:")
print(df)

# --------------------------------------------------
# STEP 5: Encode Categorical Data
# --------------------------------------------------

label_encoder = LabelEncoder()

df["City"] = label_encoder.fit_transform(df["City"])
df["Purchased"] = label_encoder.fit_transform(df["Purchased"])

print("\nAfter Encoding:")
print(df)

# --------------------------------------------------
# STEP 6: Separate Features and Target
# --------------------------------------------------

X = df.drop("Purchased", axis=1)
y = df["Purchased"]

# --------------------------------------------------
# STEP 7: Feature Scaling
# --------------------------------------------------

scaler = StandardScaler()

X_scaled = scaler.fit_transform(X)

print("\nScaled Features:")
print(X_scaled)

# --------------------------------------------------
# STEP 8: Train-Test Split
# --------------------------------------------------

X_train, X_test, y_train, y_test = train_test_split(
    X_scaled,
    y,
    test_size=0.2,
    random_state=42
)

print("\nTraining Data:")
print(X_train)

print("\nTesting Data:")
print(X_test)

print("\nTraining Target:")
print(y_train)

print("\nTesting Target:")
print(y_test)
