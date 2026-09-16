# Program 5A: Simple Linear Regression

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
from sklearn.metrics import r2_score

# --------------------------------------------------
# STEP 1: Create Dataset
# --------------------------------------------------

data = {
    "Experience": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
    "Salary": [25000, 28000, 32000, 35000, 40000,
               45000, 50000, 55000, 60000, 65000]
}

df = pd.DataFrame(data)

print("Dataset:")
print(df)

# --------------------------------------------------
# STEP 2: Define X and Y
# --------------------------------------------------

X = df[["Experience"]]
y = df["Salary"]

# --------------------------------------------------
# STEP 3: Train-Test Split
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
# STEP 5: Train Model
# --------------------------------------------------

model.fit(X_train, y_train)

# --------------------------------------------------
# STEP 6: Prediction
# --------------------------------------------------

y_pred = model.predict(X_test)

print("\nActual Salary:")
print(y_test.values)

print("\nPredicted Salary:")
print(y_pred)

# --------------------------------------------------
# STEP 7: Model Parameters
# --------------------------------------------------

print("\nCoefficient:")
print(model.coef_)

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

# --------------------------------------------------
# STEP 9: Visualization
# --------------------------------------------------

plt.scatter(X, y)

plt.plot(
    X,
    model.predict(X)
)

plt.xlabel("Years of Experience")
plt.ylabel("Salary")

plt.title("Simple Linear Regression")

plt.show()
