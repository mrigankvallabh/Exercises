package leetcode;

public class P55Canjump {
    public static void main(String[] args) {
        int[] nums = { 2, 1, 1, 2, 1 };
        boolean canJump = canJump(nums);
        System.out.println(canJump);
        System.out.println(canJump2(nums));

    }

    private static boolean canJump(int[] nums) {
        int toJumpAt = nums.length - 1;

        for (int currLoc = toJumpAt - 1; currLoc >= 0; currLoc--) {
            if (currLoc + nums[currLoc] >= toJumpAt) {
                toJumpAt = currLoc;
            }
        }
        return toJumpAt == 0;
    }

    private static int canJump2(int[] nums) {
        int left = 0;
        int right = 0;
        int nJumps = 0;
        System.out.println("Jump " + nJumps + ": " + left + ", " + right);

        while (right < nums.length - 1) {
            int maxDistance = 0;
            for (int i = left; i <= right; i++) {
                maxDistance = Math.max(maxDistance, i + nums[i]);
            }
            left = right + 1;
            right = maxDistance;
            nJumps++;
            System.out.println("Jump " + nJumps + ": " + left + ", " + right);
        }
        return nJumps;
    }
}
