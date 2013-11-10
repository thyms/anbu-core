# type 'make -s list' to see list of targets.

run-app:
	./gradlew jettyRun

test-app:
	./gradlew clean test

test-app-ci:
	./gradlew clean test

setup-app:
	git remote add functional01 git@heroku.com:anbu-core-func01.git
	git remote add qa01         git@heroku.com:anbu-core-qa01.git
	git remote add demo01       git@heroku.com:anbu-core-demo01.git
	git remote add stage01      git@heroku.com:anbu-core-stage01.git
	git remote add prod01       git@heroku.com:anbu-core-prod01.git

.PHONY: no_targets__ list
no_targets__:
list:
	sh -c "$(MAKE) -p no_targets__ | awk -F':' '/^[a-zA-Z0-9][^\$$#\/\\t=]*:([^=]|$$)/ {split(\$$1,A,/ /);for(i in A)print A[i]}' | grep -v '__\$$' | sort"
