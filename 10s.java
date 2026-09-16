# Program 6: Logistic Regression
# Real-Time Student Placement Prediction

import pandas as pd

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression

from sklearn.metrics import accuracy_score
from sklearn.metrics import confusion_matrix
from sklearn.metrics import classification_report

# --------------------------------------------------
# STEP 1: Create Dataset
# --------------------------------------------------

data = {
    "CGPA": [
        6.1, 6.5, 7.0, 7.2, 7.5,
        7.8, 8.0, 8.2, 8.5, 8.7,
        9.0, 9.2, 6.3, 6.8, 7.4,
        8.1, 8.6, 9.1, 6.0, 7.1
    ],

    "AptitudeScore": [
        45, 50, 55, 58, 60,
        65, 68, 70, 75, 78,
        82, 88, 48, 52, 62,
        72, 80, 86, 42, 57
    ],

    "Attendance": [
        70, 72, 75, 78, 80,
        82, 85, 87, 90, 91,
        94, 95, 68, 74, 81,
        88, 92, 93, 65, 77
    ],

    "Placement": [
        0, 0, 0, 0, 1,
        1, 1, 1, 1, 1,
        1, 1, 0, 0, 1,
        1, 1, 1, 0, 0
    ]
}

df = pd.DataFrame(data)

print("Student Placement Dataset:")
print(df)

# --------------------------------------------------
# STEP 2: Separate Features and Target
# --------------------------------------------------

X = df[
    [
        "CGPA",
        "AptitudeScore",
        "Attendance"
    ]
]

y = df["Placement"]

# --------------------------------------------------
# STEP 3: Train-Test Split
# --------------------------------------------------

X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.25,
    random_state=42,
    stratify=y
)

# --------------------------------------------------
# STEP 4: Feature Scaling
# --------------------------------------------------

scaler = StandardScaler()

X_train = scaler.fit_transform(X_train)

X_test = scaler.transform(X_test)

# --------------------------------------------------
# STEP 5: Create Logistic Regression Model
# --------------------------------------------------

model = LogisticRegression()

# --------------------------------------------------
# STEP 6: Train Model
# --------------------------------------------------

model.fit(X_train, y_train)

# --------------------------------------------------
# STEP 7: Prediction
# --------------------------------------------------

y_pred = model.predict(X_test)

print("\nActual Values:")
print(y_test.values)

print("\nPredicted Values:")
print(y_pred)

# --------------------------------------------------
# STEP 8: Accuracy
# --------------------------------------------------

accuracy = accuracy_score(
    y_test,
    y_pred
)

print("\nAccuracy:")
print(accuracy)

print("\nAccuracy Percentage:")
print(accuracy * 100, "%")

# --------------------------------------------------
# STEP 9: Confusion Matrix
# --------------------------------------------------

print("\nConfusion Matrix:")

print(
    confusion_matrix(
        y_test,
        y_pred
    )
)

# --------------------------------------------------
# STEP 10: Classification Report
# --------------------------------------------------

print("\nClassification Report:")

print(
    classification_report(
        y_test,
        y_pred
    )
)

# --------------------------------------------------
# STEP 11: Predict New Student
# --------------------------------------------------

new_student = [[
    8.4,     # CGPA
    76,      # Aptitude Score
    89       # Attendance
]]

new_student_scaled = scaler.transform(
    new_student
)

prediction = model.predict(
    new_student_scaled
)

probability = model.predict_proba(
    new_student_scaled
)

print("\nNew Student Prediction:")

if prediction[0] == 1:
    print("Result: PLACED")
else:
    print("Result: NOT PLACED")

print("\nPlacement Probability:")
print(probability[0][1] * 100, "%")
