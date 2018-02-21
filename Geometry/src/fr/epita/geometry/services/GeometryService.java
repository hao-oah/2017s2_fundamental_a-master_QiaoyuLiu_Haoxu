/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.geometry.services;

import java.util.List;

import fr.epita.geometry.datamodel.Shape;

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
public class GeometryService {

	public Double calculatePerimeter(List<Shape> list) {
		Double result = 0.0;
		for (final Shape shape : list) {
			result += shape.getPerimeter();
		}
		return result;
	}

	public Double calculateArea(List<Shape> list) {
		Double result = 0.0;
		for (final Shape shape : list) {
			result += shape.getArea();
		}
		return result;
	}

}
