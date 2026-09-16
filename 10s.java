# Program 5B: Multiple Linear Regression

import pandas as pd

from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
from sklearn.metrics import r2_score

# --------------------------------------------------
# STEP 1: Dataset
# --------------------------------------------------

data = {
    "Experience": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
    "Age": [22, 23, 24, 25, 27, 29, 30, 32, 34, 36],
    "Education": [60, 65, 70, 72, 75, 78, 80, 85, 88, 90],
    "Salary": [25000, 28000, 32000, 35000, 40000,
               45000, 50000, 55000, 60000, 65000]
}

df = pd.DataFrame(data)

print("Dataset:")
print(df)

# --------------------------------------------------
# STEP 2: Features and Target
# --------------------------------------------------

X = df[
    [
        "Experience",
        "Age",
        "Education"
    ]
]

y = df["Salary"]

# --------------------------------------------------
# STEP 3: Split Dataset
# --------------------------------------------------

X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.2,
    random_state=42
)

# --------------------------------------------------
# STEP 4: Create Model
# --------------------------------------------------

model = LinearRegression()

# --------------------------------------------------
# STEP 5: Train
# --------------------------------------------------

model.fit(X_train, y_train)

# --------------------------------------------------
# STEP 6: Prediction
# --------------------------------------------------

y_pred = model.predict(X_test)

print("\nActual Values:")
print(y_test.values)

print("\nPredicted Values:")
print(y_pred)

# --------------------------------------------------
# STEP 7: Coefficients
# --------------------------------------------------

print("\nCoefficients:")

for feature, coefficient in zip(
    X.columns,
    model.coef_
):
    print(feature, ":", coefficient)

print("\nIntercept:")
print(model.intercept_)

# --------------------------------------------------
# STEP 8: Evaluation
# --------------------------------------------------

mse = mean_squared_error(y_test, y_pred)

r2 = r2_score(y_test, y_pred)

print("\nMean Squared Error:")
print(mse)

print("\nR2 Score:")
print(r2)
