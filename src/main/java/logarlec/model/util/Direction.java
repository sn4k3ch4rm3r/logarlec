package logarlec.model.util;

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

	};

	public abstract int getX();

	public abstract int getY();
}
