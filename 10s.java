# Program 4: K-Nearest Neighbour Classification

import numpy as np

from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score
from sklearn.metrics import confusion_matrix
from sklearn.metrics import classification_report

# --------------------------------------------------
# STEP 1: Load Dataset
# --------------------------------------------------

iris = load_iris()

X = iris.data
y = iris.target

# --------------------------------------------------
# STEP 2: Split Dataset
# --------------------------------------------------

X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.2,
    random_state=42,
    stratify=y
)

# --------------------------------------------------
# STEP 3: Feature Scaling
# --------------------------------------------------

scaler = StandardScaler()

X_train = scaler.fit_transform(X_train)
X_test = scaler.transform(X_test)

# --------------------------------------------------
# STEP 4: Create KNN Model
# --------------------------------------------------

k = 5

model = KNeighborsClassifier(n_neighbors=k)

# --------------------------------------------------
# STEP 5: Train Model
# --------------------------------------------------

model.fit(X_train, y_train)

# --------------------------------------------------
# STEP 6: Prediction
# --------------------------------------------------

y_pred = model.predict(X_test)

# --------------------------------------------------
# STEP 7: Accuracy
# --------------------------------------------------

accuracy = accuracy_score(y_test, y_pred)

print("K value:", k)

print("\nAccuracy:")
print(accuracy)

print("\nAccuracy Percentage:")
print(accuracy * 100, "%")

# --------------------------------------------------
# STEP 8: Correct and Wrong Predictions
# --------------------------------------------------

print("\nCorrect Predictions:")

for actual, predicted in zip(y_test, y_pred):

    if actual == predicted:
        print(
            "Actual:",
            iris.target_names[actual],
            "Predicted:",
            iris.target_names[predicted]
        )

print("\nWrong Predictions:")

for actual, predicted in zip(y_test, y_pred):

    if actual != predicted:
        print(
            "Actual:",
            iris.target_names[actual],
            "Predicted:",
            iris.target_names[predicted]
        )

# --------------------------------------------------
# STEP 9: Confusion Matrix
# --------------------------------------------------

print("\nConfusion Matrix:")
print(confusion_matrix(y_test, y_pred))

# --------------------------------------------------
# STEP 10: Classification Report
# --------------------------------------------------

print("\nClassification Report:")
print(
    classification_report(
        y_test,
        y_pred,
        target_names=iris.target_names
    )
)
