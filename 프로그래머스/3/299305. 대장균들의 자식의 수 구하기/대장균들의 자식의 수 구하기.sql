-- 코드를 작성해주세요
SELECT parent.ID, COALESCE(COUNT(child.ID), 0) AS CHILD_COUNT
FROM ECOLI_DATA parent
LEFT JOIN ECOLI_DATA child
ON parent.ID = child.PARENT_ID
GROUP BY parent.id
ORDER BY parent.id