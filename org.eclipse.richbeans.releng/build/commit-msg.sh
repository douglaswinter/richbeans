#!/usr/bin/env bash



# We check the last commit message has a ticket
if [[ $last_msg =~ .*(richbeans/issues/[0-9]+).* ]]; then
    echo "Github issue found, build may proceed"
    exit 0
fi

# Couldn't find ticket or merge, fail build
error_msg="Aborting build. Your commit message must reference a github issue"
echo "$error_msg" >&2

# Get the last user
id="$(git log --format="%H" -n 1)"
user="$(git show --format="%aN <%aE>" $id)"
echo "Last commit from:"
echo " $user"

exit 1