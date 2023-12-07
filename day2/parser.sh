grep -nE -o '[1-9]{1,2} [b,g,r]' input.txt | tr ':' ' ' | awk 'BEGIN{cols["r"] = 12; cols["b"] = 14; cols["g"] = 13} {if ($2 > cols[$3]){print $1}}' | uniq | awk '{sum +=$1} END{print sum}'
