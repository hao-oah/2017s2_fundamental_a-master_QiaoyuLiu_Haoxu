/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.geometry.launcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Shape;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;
import fr.epita.geometry.services.GeometryService;

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
public class Launcher {

	public static void main(String[] args) {
		final GeometryService geometry = new GeometryService();

		final Shape circle1 = new Circle(20.0);
		final Shape circle2 = new Circle(40.0);
		final Shape circle3 = new Circle(30.0);

		final List<Shape> circleList = Arrays.asList(circle1, circle2, circle3);

		final Triangle triangle1 = new Triangle(20.0, 10.0, 5.0, 15.0);
		final Triangle triangle2 = new Triangle(30.0, 20.0, 10.0, 20.0);
		final Triangle triangle3 = new Triangle(40.0, 30.0, 15.0, 25.0);

		final List<Triangle> triangleList = Arrays.asList(triangle1, triangle2, triangle3);

		final Square sq1 = new Square(10.0);
		final Square sq2 = new Square(20.0);
		final Square sq3 = new Square(30.0);

		final List<Square> squareList = Arrays.asList(sq1, sq2, sq3);

		final List<Shape> shapesList = new ArrayList<>();
		shapesList.addAll(circleList);
		shapesList.addAll(triangleList);
		shapesList.addAll(squareList);

		System.out.println(geometry.calculatePerimeter(shapesList));
		System.out.println(geometry.calculateArea(shapesList));

	}



}