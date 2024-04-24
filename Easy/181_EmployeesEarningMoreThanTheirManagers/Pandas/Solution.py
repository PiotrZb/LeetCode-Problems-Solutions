import pandas as pd

def find_employees(employee: pd.DataFrame) -> pd.DataFrame:
    df = employee.merge(employee, left_on="managerId", right_on="id", how="inner")
    df = df[df["salary_x"] > df["salary_y"]].rename(columns={"name_x" : "Employee"})
    return df[["Employee"]]