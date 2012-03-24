package at.ac.foop.pacman.domain;

/**
 *
 * @author Phil
 */
final public class Field extends Square {
	private Player player; //The current player on this square or null for no player
	private Integer points; //The number of points of this square
	
	public Field(Integer points) {
		this.reset();
	}
	
	@Override
	public void enter(Player player) {
		if(this.player == null) {
			this.player = player;
			
			if(points != 0) {
				player.addPoints(points);
				points = 0;
			}
		} else {
			this.player.eat(player);
		}
	}

	@Override
	public void leave(Player player) {
		if(this.player == player) {
			this.player = null;
		} else {
			throw new RuntimeException("A Player that " +
					"is not on this field can not leave this field.");
		}
	}
	
	public Player getPlayer() {
		return this.player;
	}

	@Override
	public void reset() {
		this.player = null;
		this.points = 0;
	}
	
	@Override
	public SquareType getType() {
		return SquareType.FIELD;
	}
	
	@Override
	public Integer getPoints() {
		return points;
	}
}
