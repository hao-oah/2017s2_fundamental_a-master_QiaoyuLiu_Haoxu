/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.geometry.datamodel;

/**
 * <h3>Description</h3>
 * <p>This class allows to ...</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */
public class Triangle implements Shape {

	private Double base;
	private Double height;
	private Double sideA;
	private Double sideB;
	/**
	 * @return the base
	 */
	public Double getBase() {
		return base;
	}
	/**
	 * @param base the base to set
	 */
	public void setBase(Double base) {
		this.base = base;
	}
	/**
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}
	/**
	 * @return the sideA
	 */
	public Double getSideA() {
		return sideA;
	}
	/**
	 * @param sideA the sideA to set
	 */
	public void setSideA(Double sideA) {
		this.sideA = sideA;
	}
	/**
	 * @return the sideB
	 */
	public Double getSideB() {
		return sideB;
	}
	/**
	 * @param sideB the sideB to set
	 */
	public void setSideB(Double sideB) {
		this.sideB = sideB;
	}
	/**
	 * @param base
	 * @param height
	 * @param sideA
	 * @param sideB
	 */
	public Triangle(Double base, Double height, Double sideA, Double sideB) {
		this.base = base;
		this.height = height;
		this.sideA = sideA;
		this.sideB = sideB;
	}

	@Override
	public Double getArea() {
		return base * height / 2;
	}

	@Override
	public Double getPerimeter() {
		return base + sideA + sideB;
	}


}
