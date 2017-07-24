#!/bin/bash

echo "开始提交代码到github"
echo "git add -A"
git add -A

echo "git commit"
echo "请输入commit的注释信息：$1"
git commit -m “$1”

echo "git fetch origin master"
git fetch origin master

echo "git merge origin/master"
git merge origin/master

echo "git push origin master:master"
git push origin master:master
