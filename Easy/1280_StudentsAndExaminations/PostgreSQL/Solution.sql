SELECT T1.student_id, T1.student_name, T1.subject_name, COALESCE(T2.attended_exams, 0) AS attended_exams
FROM (
    SELECT student_id, student_name, subject_name
    FROM Students
    CROSS JOIN Subjects
) AS T1
LEFT JOIN (
    SELECT student_id, subject_name, COUNT(subject_name) AS attended_exams
    FROM Examinations
    GROUP BY student_id, subject_name
) AS T2 ON T1.student_id = T2.student_id AND T1.subject_name = T2.subject_name
ORDER BY T1.student_id, T1.subject_name;