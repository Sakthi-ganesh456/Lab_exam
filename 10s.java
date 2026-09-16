# PROGRAM 8
# Naive Bayes Classification
# Iris Dataset from CSV File

import pandas as pd

from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import GaussianNB
from sklearn.metrics import accuracy_score

# --------------------------------------------------
# STEP 1: Load Dataset from CSV
# --------------------------------------------------

df = pd.read_csv("Iris.csv")

print("Iris Dataset:")
print(df.head())

# --------------------------------------------------
# STEP 2: Select Features and Target
# --------------------------------------------------

X = df[
    [
        "SepalLengthCm",
        "SepalWidthCm",
        "PetalLengthCm",
        "PetalWidthCm"
    ]
]

y = df["Species"]

# --------------------------------------------------
# STEP 3: Split Dataset into Training and Testing
# --------------------------------------------------

X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.2,
    random_state=42,
    stratify=y
)

# --------------------------------------------------
# STEP 4: Create Naive Bayes Model
# --------------------------------------------------

model = GaussianNB()

# --------------------------------------------------
# STEP 5: Train the Model
# --------------------------------------------------

model.fit(X_train, y_train)

# --------------------------------------------------
# STEP 6: Predict Test Data
# --------------------------------------------------

y_pred = model.predict(X_test)

# --------------------------------------------------
# STEP 7: Display Actual and Predicted Values
# --------------------------------------------------

print("\nActual and Predicted Values:")
print("--------------------------------")

for actual, predicted in zip(y_test, y_pred):

    if actual == predicted:
        print(
            "Actual:",
            actual,
            " Predicted:",
            predicted,
            " --> Correct"
        )
    else:
        print(
            "Actual:",
            actual,
            " Predicted:",
            predicted,
            " --> Wrong"
        )

# --------------------------------------------------
# STEP 8: Calculate Accuracy
# --------------------------------------------------

accuracy = accuracy_score(y_test, y_pred)

print("\n--------------------------------")
print("Naive Bayes Accuracy:", accuracy * 100, "%")
