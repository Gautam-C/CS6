package Magpie;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.indexOf("no") >= 0)
        {
            response = "Why so negative?";
        }

        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
        {
            response = "Tell me more about your family.";
        }

        else if (statement.indexOf("dog") >= 0
                || statement.indexOf("cat") >= 0)
        {
            response = "Tell me more about your pets";
        }
        //         else if (findKeyword(statement, "I want to", 0) >= 0)
        // 		{
        // 			response = transformIWantToStatement(statement);
        // 		}

        else if (statement.indexOf("work") >= 0
                || statement.indexOf("job") >= 0) {

            response = "Tell me more about your job";
        }

        else if (statement.indexOf("Maitreya") >= 0) {

            response = "Je se connais. Il est bête.";
        }

        else if (statement.indexOf("define") >= 0) {
            response = "I'm not a dictionary";
        }

        else if (statement.indexOf("add") >= 0
                || statement.indexOf("subtract") >= 0
                || statement.indexOf("divide") >= 0
                || statement.indexOf("multiply") >= 0
                || statement.indexOf("sqrt") >= 0) {
            response = "I'm not a calculator";
        }

        else if (statement.indexOf("hate") >= 0) {
            response = "yes";
        }

        else if ((statement.trim()).length() == 0) {
            response = "Please enter something ...";
        }

        else
        {

            //             // Look for a two word (you <something> me) pattern
            //             int psn = findKeyword(statement, "you", 0);
            //
            //             if (psn >= 0
            //             && findKeyword(statement, "me", psn) >= 0)
            //             {
            //                 response = transformYouMeStatement(statement);
            //             }
            //             else {
            response = getRandomResponse();
            //             }
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4) {
            response = "I'm definitely listening to you ...";
        }
        else if (whichResponse == 5) {
            response = "And?";
        }
        return response;
    }

         private int findKeyword(String statement, String goal, int startPos)
         {
             String phrase = statement.trim();
             int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
             while (psn >= 0)
             {
                 String before = " ", after = " ";
                 if (psn > 0)
                 {
                     before = phrase.substring (psn - 1, psn).toLowerCase();
                 }
                 if (psn + goal.length() < phrase.length())
                 {
                     after = phrase.substring(psn + goal.length(),
                         psn + goal.length() + 1).toLowerCase();
                 }

                 /**
                  * determine the values of psn, before, and after at this point in the method.
                 **/

                 if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0)) &&
                 ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
                 {
                     return psn;
                 }
                 psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
             }
             return -1;
         }

    // /**
    // 	 * Take a statement with "I want to <something>." and transform it into
    // 	 * "What would it mean to <something>?"
    // 	 * @param statement the user statement, assumed to contain "I want to"
    // 	 * @return the transformed statement
    // 	 */
    // 	private String transformIWantToStatement(String statement)
    // 	{
    // 		//  Remove the final period, if there is one
    // 		statement = statement.trim();
    // 		String lastChar = statement.substring(statement
    // 				.length() - 1);
    // 		if (lastChar.equals("."))
    // 		{
    // 			statement = statement.substring(0, statement
    // 					.length() - 1);
    // 		}
    // 		int psn = findKeyword (statement, "I want to", 0);
    // 		String restOfStatement = statement.substring(psn + 9).trim();
    // 		return "What would it mean to " + restOfStatement + "?";
    // 	}

    // 	/**
    // 	 * Take a statement with "I want <something>." and transform it into
    // 	 * "Would you really be happy if you had <something>?"
    // 	 * @param statement the user statement, assumed to contain "I want"
    // 	 * @return the transformed statement
    // 	 */
    // 	private String transformIWantStatement(String statement)
    // 	{
    // 		//to be implemented in Activity 4
    // 	}

    // 	/**
    // 	 * Take a statement with "you <something> me" and transform it into
    // 	 * "What makes you think that I <something> you?"
    // * @param statement the user statement, assumed to contain "you" followed by "me"
    // 	 * @return the transformed statement
    // 	 */
    // 	private String transformYouMeStatement(String statement)
    // 	{
    // 		//  Remove the final period, if there is one
    // 		statement = statement.trim();
    // 		String lastChar = statement.substring(statement
    // 				.length() - 1);
    // 		if (lastChar.equals("."))
    // 		{
    // 			statement = statement.substring(0, statement
    // 					.length() - 1);
    // 		}
    //
    // 		int psnOfYou = findKeyword (statement, "you", 0);
    // 		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
    //
    // 	String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
    // 		return "What makes you think that I " + restOfStatement + " you?";
    // 	}

    // 	/**
    // 	 * Take a statement with "I <something> you" and transform it into
    // 	 * "Why do you <something> me?"
    // * @param statement the user statement, assumed to contain "I" followed by "you"
    // 	 * @return the transformed statement
    // 	 */
    // 	private String transformIYouStatement(String statement)
    // 	{
    // 		//to be implemented in Activity 4
    // 	}

}