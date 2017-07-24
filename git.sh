#!/bin/bash

echo "开始提交代码到github"
echo "git add -A"
git add -A

echo "git commit"
read -p "请输入commit的注释信息:" comment
git commit -m “$comment”

echo "git fetch origin master"
git fetch origin master

echo "git merge origin/master"
git merge origin/master

echo "git push origin master:master"
git push origin master:master

sleep 5s #睡眠5s
