SELECT user_id, name, mail
FROM users
WHERE REGEXP_LIKE(mail COLLATE utf8mb3_bin, '^[A-Za-z][A-Za-z0-9_.-]*@leetcode\\.com$');
