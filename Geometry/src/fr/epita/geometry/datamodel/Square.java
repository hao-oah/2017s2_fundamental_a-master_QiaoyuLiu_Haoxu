/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.geometry.datamodel;

/**
 * <h3>Description</h3>
 * <p>
 * This class allows to ...
 * </p>
 *
 * <h3>Usage</h3>
 * <p>
 * This class should be used as follows:
 *
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class Square implements Shape {

	private Double side;

	/**
	 * @return the side
	 */
	public Double getSide() {
		return side;
	}

	/**
	 * @param side
	 *            the side to set
	 */
	public void setSide(Double side) {
		this.side = side;
	}

	/**
	 * @param side
	 */
	public Square(Double side) {
		this.side = side;
	}

	@Override
	public Double getArea() {
		// return Math.pow(this.side, 2);
		return side * side;
	}

	@Override
	public Double getPerimeter() {
		return 4 * side;
	}
}
