# PROGRAM 7
# Support Vector Machine Classification
# Iris Dataset

import pandas as pd

from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn.metrics import accuracy_score

# --------------------------------------------------
# STEP 1: Load Dataset
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
# STEP 3: Split Dataset
# --------------------------------------------------

X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.2,
    random_state=42,
    stratify=y
)

# --------------------------------------------------
# STEP 4: Create SVM Model
# --------------------------------------------------

model = SVC(kernel="linear")

# --------------------------------------------------
# STEP 5: Train Model
# --------------------------------------------------

model.fit(X_train, y_train)

# --------------------------------------------------
# STEP 6: Make Predictions
# --------------------------------------------------

y_pred = model.predict(X_test)

# --------------------------------------------------
# STEP 7: Print Actual and Predicted Values
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
print("SVM Accuracy:", accuracy * 100, "%")
