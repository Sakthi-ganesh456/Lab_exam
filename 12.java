import matplotlib.pyplot as plt
from sklearn.datasets import fetch_california_housing
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
data = fetch_california_housing()
X = data.data[:, [5]]
y = data.target
X_train, X_test, y_train, y_test = train_test_split(
X, y, test_size=0.2, random_state=42
)
model = LinearRegression()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)
print("Mean Squared Error:", mean_squared_error(y_test, y_pred))
print("R2 Score:", r2_score(y_test, y_pred))
plt.scatter(X_test, y_test, alpha=0.5)
plt.plot(X_test, y_pred, color='red')
plt.xlabel("Average Number of Rooms")
plt.ylabel("House Value (in $100,000)")
plt.title("Simple Linear Regression - Housing")
plt.show()
