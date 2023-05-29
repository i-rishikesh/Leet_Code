class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        def reverse(x):
            """
            :type x: int
            :rtype: int
            """
            r = x % 10
            q = x // 10
            ans = r

            while q != 0:
                r = q % 10
                q //= 10
                ans = ans * 10 + r

            return ans

        if x < 0:
            return False

        rev = reverse(x)

        if rev == x:
            return True

        else:
            return False
          