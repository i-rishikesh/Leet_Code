class Solution:
    def myAtoi(self, s: str) -> int:
        if len(s) == 0:
            return 0

        start = False
        neg = False
        ans = 0
        upper = 2**31
        lower = -2**31

        for c in s:
            if not start:
                if c == ' ':
                    continue
                elif not (c.isdigit() or c in "+-"):
                    return 0
                else:
                    if c == '-':
                        neg = True
                    elif c.isdigit():
                        if neg:
                            ans = -int(c)
                        else:
                            ans = int(c)

                start = True
            else:
                if c.isdigit():
                    if not neg:
                        ans = ans * 10 + int(c)
                    else:
                        ans = ans * 10 - int(c)

                    if ans not in range(lower, upper):
                        if ans > 0:
                            return upper - 1
                        else:
                            return lower
                else:
                    break
        
        return ans