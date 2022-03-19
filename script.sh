#!/bin/sh

#Script for automatic retrieval of Bug data related to SATD

filename="input.txt"

while IFS= read -r line 
do
	IFS=',' read -r -a array <<< "$line"
  
  #Read input file line by line: each line is structured as "id,repository,file_path,SATD_comment"
  #Each line is split into array, with ',' as separator
    name="$line" 
    comment="${array[3]}"
    printf "  Comment: %s\n" "$comment" #print '//TODO...' for each line
  
  #Search in git history for commits that include the current SATD comment
    gitcomm="$(git log -S"${comment}" --oneline)" 
    
  #Store result of previous command: the bottom and top commit (it is usually two, but may be more) are respectively
  #the commit where the SATD was introduced and the commit where it was removed 
    IFS=$'\n' read -d '' -r -a comm <<< "$gitcomm" 
    
    sha1=${comm[${#comm[@]}-1]:0:9} #last element of array
    sha2=${comm[0]:0:9}
    #echo " Bugs between: "
    #git log $sha1..$sha2 --oneline -- ${array[2]} | grep -i 'Bug [0-9]'

  #Search in git history between the first (SATD introduced) and second (SATD removed) sha in the Java class containing the SATD, 
  #and search for commits that refer to bugs - their message looks like "Bug 12345"
    between="$(git log $sha1..$sha2 --oneline -- ${array[2]} | grep -i 'Bug [0-9]')"
    betweenNum="$(git log $sha1..$sha2 --oneline -- ${array[2]} | grep -i 'Bug [0-9]' | wc -l)"

    #TODO: remove from count commits with the same bug id

    #echo " Bugs after: "
    #git log $sha2.. --oneline -- ${array[2]} | grep -i 'Bug [0-9]'

  #Search between the second sha (SATD removed) until the most recent existing commit for the same Class
    after="$(git log $sha2.. --oneline -- ${array[2]} | grep -i 'Bug [0-9]')"
    afterNum="$(git log $sha2.. --oneline -- ${array[2]} | grep -i 'Bug [0-9]' | wc -l)"
  
  #Print result to file  
    output=BugResults/${array[0]}_comment.txt
    echo "File path: ${array[2]}" > $output
    echo "Comment: $comment" >> $output
    echo "Initial commit id: $sha1" >> $output
    echo "Final commit id: $sha2" >> $output
    echo "   Bugs between [$betweenNum]:" >> $output
    echo "$between" >> $output
    echo ""
    echo "   Bugs after [$afterNum]:" >> $output
    echo "$after" >> $output 
    
done < "$filename"

