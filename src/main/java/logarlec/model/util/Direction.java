package logarlec.model.util;

/**
 * Az irányokat reprezentáló enum.
 */
public enum Direction {
	UP {
		@Override
		public int getX() {
			return 0;
		}

		@Override
		public int getY() {
			return -1;
		}

		@Override
		public Direction getOpposite() {
			return DOWN;
		}
	},
	DOWN {
		@Override
		public int getX() {
			return 0;
		}

		@Override
		public int getY() {
			return 1;
		}

		@Override
		public Direction getOpposite() {
			return UP;
		}
	},
	LEFT {
		@Override
		public int getX() {
			return -1;
		}

		@Override
		public int getY() {
			return 0;
		}

		@Override
		public Direction getOpposite() {
			return RIGHT;
		}
	},
	RIGHT {
		@Override
		public int getX() {
			return 1;
		}

		@Override
		public int getY() {
			return 0;
		}

		@Override
		public Direction getOpposite() {
			return LEFT;
		}
	};

	public abstract int getX();

	public abstract int getY();

	public abstract Direction getOpposite();
}
