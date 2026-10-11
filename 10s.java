#Data perprocessing(any dataset)
import pandas as pd
from sklearn.preprocessing import MinMaxScaler, LabelEncoder
df = pd.DataFrame({
'Name': ['Arun', 'Bala', 'Cathy', 'David', 'Arun'],
'Age': [20, 25, None, 30, 20],
'Salary': [20000, 30000, 25000, None, 20000],
'City': ['Madurai', 'Chennai', 'Madurai', 'Trichy', 'Madurai']
})
print("Original Data:\n", df)
df = df.drop_duplicates()
df['Age'] = df['Age'].fillna(df['Age'].mean())
df['Salary'] = df['Salary'].fillna(df['Salary'].mean())
encoder = LabelEncoder()
df['City'] = encoder.fit_transform(df['City'])
scaler = MinMaxScaler()
df[['Age', 'Salary']] = scaler.fit_transform(df[['Age', 'Salary']])
print("\nPreprocessed Data:\n", df)
