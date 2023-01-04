# Calculator implementation in Java

#### A Package calculator is created and and inside the package below are list of classes defined to implement calculator:
1. **Main class:** 
   - Calls constructor of CalcFrame class to initialize calculator GUI buttons and frame axis, width, height etc. 
   - Creates instance of CalcFrame class to call methods to create calculator GUI.
   - Call method to add buttons to calculator GUI.
2. **CalcFrame :** 
   - Variables to set calculator axis and button dimentions are initialized.
   - Creates a frame to implement calculator GUI.
   - Add buttons to calculator.
   - Calls method of class Input to track the button clicks and store clicks information.
   - Calls method of class Calculation to perform final calculation as soon as button "=" is clicked.
3. **Input :**
   - Track the input and operations to be performed based on buttons clicks.
   - Handles NumberFormatException if this exception occurs for various scenarios e.g. operators(=, -, *, /) are clicked in wrong order.
4. **Calculation :**
   - Perform the actual calculation once "=" button is clicked.
   - Handles ArithmeticException if this exception occurs during mathematical operations of numbers.
