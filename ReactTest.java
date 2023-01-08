//import required classes and packages
import org.junit.*;

class ReactTest {

	private int x1 = 3;

	private int x2 = 0;

	private int x3 = 0;

	private int x4 = 0;

	private int x5 = 0;

	private int a = 1;

	private React react;

		@Before
		public void setUp()  {

			react = new React();

			react.newPost(1);

		}

	  //count reactions to a post
		public void testReact( int a) {


			        if (a == 1){

				        x1 = x1 + 1;

					} else if (a == 2) {

						x2= x2 + 1;

				    }else if (a == 3) {

						x3= x3 + 1;

					}else if (a == 4) {

						x4= x4 + 1;

					}else if (a == 5) {

						x5= x5 + 1;

					}

					Assert.assertEquals("failure - wrong counting", x1, 4);


			    }




}