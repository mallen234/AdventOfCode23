grep -nE -o '[0-9]{1,2} [b,g,r]' input.txt | tr ':' ' ' | awk ' BEGIN {cur = 1;powers = 0} {if ($1 > cur){powers += (arr["r"]*arr["b"]*arr["g"]);arr["r"]=0;arr["b"]=0;arr["g"]=0; cur+=1}; if ($2 > arr[$3]){arr[$3] = $2}}  END {print (powers+= (arr["r"]*arr["b"]*arr["g"])) }'