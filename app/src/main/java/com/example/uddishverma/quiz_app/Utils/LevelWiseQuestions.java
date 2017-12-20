package com.example.uddishverma.quiz_app.Utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by uddishverma on 19/12/17.
 */

public class LevelWiseQuestions {


    public static String levelOneQuestions = "{\n" +
            "\"results\": [\n" +
            "{\n" +
            "\"id\": \"0\",\n" +
            "\"question\": \"Which movie released in 2016 features Superman and Batman fighting?\",\n" +
            "\"correct_answer\": \"Batman v Superman: Dawn of Justice\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Batman v Superman: Dawn of Justice\",\n" +
            "\"Batman v Superman: Superapocalypse\",\n" +
            "\"Batman v Superman: Black of Knight\",\n" +
            "\"Batman v Superman: Knightfall\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"1\",\n" +
            "\"question\": \"Daniel Radcliffe became a global star in the film industry due to his performance in which film franchise?\",\n" +
            "\"correct_answer\": \"Harry Potter\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Ted\",\n" +
            "\"Spy Kids\",\n" +
            "\"Harry Potter\",\n" +
            "\"Pirates of the Caribbean \"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"2\",\n" +
            "\"question\": \"What name did Tom Hanks give to his volleyball companion in the film `Cast Away`?\",\n" +
            "\"correct_answer\": \"Wilson\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Friday\",\n" +
            "\"Jones\",\n" +
            "\"Wilson\",\n" +
            "\"Billy\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"3\",\n" +
            "\"question\": \"Who directed E.T. the Extra-Terrestrial (1982)?\",\n" +
            "\"correct_answer\": \"Steven Spielberg\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Steven Spielberg\",\n" +
            "\"Stanley Kubrick\",\n" +
            "\"James Cameron\",\n" +
            "\"Tim Burton\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"4\",\n" +
            "\"question\": \"Who played the female lead in the 1933 film King Kong?\",\n" +
            "\"correct_answer\": \"Fay Wray\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Jean Harlow\",\n" +
            "\"Vivien Leigh\",\n" +
            "\"Fay Wray\",\n" +
            "\"Mae West\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"5\",\n" +
            "\"question\": \"The Queen song `A Kind Of Magic` is featured in which 1986 film?\",\n" +
            "\"correct_answer\": \"Highlander\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Flash Gordon\",\n" +
            "\"Highlander\",\n" +
            "\"Labyrinth\",\n" +
            "\"Howard the Duck\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"6\",\n" +
            "\"question\": \"What was the title of the first Bond movie, released in 1962?\",\n" +
            "\"correct_answer\": \"Dr. No\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"From Russia with Love\",\n" +
            "\"Goldfinger\",\n" +
            "\"Thunderball\",\n" +
            "\"Dr. No\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"7\",\n" +
            "\"question\": \"What is the orange and white bot name in Star Wars: The Force Awakens?\",\n" +
            "\"correct_answer\": \"BB-8\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"BB-8\",\n" +
            "\"BB-3\",\n" +
            "\"AA-A\",\n" +
            "\"R2-D2\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"8\",\n" +
            "\"question\": \"What was the first James Bond film?\",\n" +
            "\"correct_answer\": \"Dr. No\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Goldfinger\",\n" +
            "\"Dr. No\",\n" +
            "\"From Russia With Love\",\n" +
            "\"Thunderball\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"9\",\n" +
            "\"question\": \"What is the oldest Disney film?\",\n" +
            "\"correct_answer\": \"Snow White and the Seven Dwarfs\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Pinocchio\",\n" +
            "\"Dumbo\",\n" +
            "\"Snow White and the Seven Dwarfs\",\n" +
            "\"Fantasia\"\n" +
            "]\n" +
            "}\n" +
            "]\n" +
            "}";

    public static String levelTwoQuestions = "{\n" +
            "\"results\": [\n" +
            "{\n" +
            "\"id\": \"0\",\n" +
            "\"question\": \"Which of these characters in Stranger Things has the power of Telekinesis?\",\n" +
            "\"correct_answer\": \"Eleven\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Eleven\",\n" +
            "\"Mike\",\n" +
            "\"Lucas\",\n" +
            "\"Karen\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"1\",\n" +
            "\"question\": \"In the show Stranger Things, what is Eleven favorite breakfast food?\",\n" +
            "\"correct_answer\": \"Eggo Waffles\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Toast\",\n" +
            "\"Eggo Waffles\",\n" +
            "\"Captain Crunch\",\n" +
            "\"Bacon and Eggs\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"2\",\n" +
            "\"question\": \"In the show, Doctor Who, what does T.A.R.D.I.S stand for?\",\n" +
            "\"correct_answer\": \"Time And Relative Dimensions In Space\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Time And Resting Dimensions In Space\",\n" +
            "\"Time And Relative Dimensions In Space\",\n" +
            "\"Time And Relative Dimensions In Style\",\n" +
            "\"Toilet Aid Rope Dog Is Soup\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"3\",\n" +
            "\"question\": \"How many seasons did Stargate have?\",\n" +
            "\"correct_answer\": \"10\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"3\",\n" +
            "\"10\",\n" +
            "\"7\",\n" +
            "\"12\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"4\",\n" +
            "\"question\": \"Who is the main character in the show Burn Notice\",\n" +
            "\"correct_answer\": \"Michael Westen\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Sam Axe\",\n" +
            "\"Michael Westen\",\n" +
            "\"Fiona Glenanne\",\n" +
            "\"Madeline Westen\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"5\",\n" +
            "\"question\": \"In Game of Thrones, what is Littlefinger's real name?\",\n" +
            "\"correct_answer\": \"Petyr Baelish\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Petyr Baelish\",\n" +
            "\"Podrick Payne\",\n" +
            "\"Lancel Lannister\",\n" +
            "\"Torrhen Karstark\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"6\",\n" +
            "\"question\": \"In the show Tengen Toppa Gurren Lagann what is the name of the character who force everyone to live underground?\",\n" +
            "\"correct_answer\": \"Lordgenome\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Kingloname\",\n" +
            "\"Lord Genome\",\n" +
            "\"King Loname\",\n" +
            "\"Lordgenome\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"7\",\n" +
            "\"question\": \"British actor David Morrissey stars as which role in The Walking Dead?\",\n" +
            "\"correct_answer\": \"The Governor\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Negan\",\n" +
            "\"Rick Grimes\",\n" +
            "\"The Governor\",\n" +
            "\"Daryl Dixon\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"8\",\n" +
            "\"question\": \"Which of these Disney shows is classified as an anime?\",\n" +
            "\"correct_answer\": \"Stitch!\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Cory in the House\",\n" +
            "\"The Emperor New School\",\n" +
            "\"Hannah Montana\",\n" +
            "\"Stitch!\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"9\",\n" +
            "\"question\": \"Which actor portrays Walter White in the series Breaking Bad?\",\n" +
            "\"correct_answer\": \"Bryan Cranston\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Andrew Lincoln\",\n" +
            "\"Bryan Cranston\",\n" +
            "\"Aaron Paul\",\n" +
            "\"RJ Mitte\"\n" +
            "]\n" +
            "}\n" +
            "]\n" +
            "}";

    public static String levelThreeQuestions = "{\n" +
            "\"results\": [\n" +
            "{\n" +
            "\"id\": \"0\",\n" +
            "\"question\": \"Which 1958 movie starred Kirk Douglas and Tony Curtis as half-brothers Einar and Eric?\",\n" +
            "\"correct_answer\": \"The Vikings\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"The Long Ships\",\n" +
            "\"The Vikings\",\n" +
            "\"Prince Valiant\",\n" +
            "\"Spartacus\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"1\",\n" +
            "\"question\": \"Which retired American football quarterback played himself in Ace Ventura: Pet Detective and Little Nicky?\",\n" +
            "\"correct_answer\": \"Dan Marino\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"John Elway\",\n" +
            "\"Tom Brady\",\n" +
            "\"Dan Marino\",\n" +
            "\"Joe Montana\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"2\",\n" +
            "\"question\": \"Velma Kelly and Roxie Hart are the protagonists of which Oscar winning movie?\",\n" +
            "\"correct_answer\": \"Chicago\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Dreamgirls\",\n" +
            "\"Chicago\",\n" +
            "\"Cabaret\",\n" +
            "\"All That Jazz\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"3\",\n" +
            "\"question\": \"What is the name of the robot in the 1951 science fiction film classic The Day the Earth Stood Still?\",\n" +
            "\"correct_answer\": \"Gort\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Gort\",\n" +
            "\"Robby\",\n" +
            "\"Colossus\",\n" +
            "\"Box\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"4\",\n" +
            "\"question\": \"This movie contains the quote, I love the smell of napalm in the morning!\",\n" +
            "\"correct_answer\": \"Apocalypse Now\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Platoon\",\n" +
            "\"The Deer Hunter\",\n" +
            "\"Full Metal Jacket\",\n" +
            "\"Apocalypse Now\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"5\",\n" +
            "\"question\": \"What is the name of the dog that played Toto in the 1939 film The Wizard of Oz?\",\n" +
            "\"correct_answer\": \"Terry\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Tommy\",\n" +
            "\"Teddy\",\n" +
            "\"Terry\",\n" +
            "\"Toto\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"6\",\n" +
            "\"question\": \"Who played Baron Victor Frankestein in the 1957 Hammer horror film The Curse of Frankenstein?\",\n" +
            "\"correct_answer\": \"Peter Cushing\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Boris Karloff\",\n" +
            "\"Peter Cushing\",\n" +
            "\"Vincent Price\",\n" +
            "\"Lon Chaney Jr.\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"7\",\n" +
            "\"question\": \"Darth Vader's famous reveal to Luke is iconic. But which of these is the right one?\",\n" +
            "\"correct_answer\": \"No. I am your father.\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Luke, I am your father.\",\n" +
            "\"You are wrong. I am your father.\",\n" +
            "\"The truth is that I am your father\",\n" +
            "\"No. I am your father.\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"8\",\n" +
            "\"question\": \"What is the make and model of the tour vehicles in Jurassic Park?\",\n" +
            "\"correct_answer\": \"1992 Ford Explorer XLT\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"1992 Ford Explorer XLT\",\n" +
            "\"1992 Toyota Land Cruiser\",\n" +
            "\"1992 Jeep Wrangler YJ Sahar\",\n" +
            "\"Mercedes M-Class\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"9\",\n" +
            "\"question\": \"In Jurassic World, which company purchases InGen and creates Jurassic World?\",\n" +
            "\"correct_answer\": \"Masrani Global Corporation\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Biology Synthetics Technologies\",\n" +
            "\"International Genetic Technologies\",\n" +
            "\"Masrani Global Corporation\",\n" +
            "\"International Genetic Technologies\"\n" +
            "]\n" +
            "}\n" +
            "]\n" +
            "}";

    public static String levelFourQuestions = "{\n" +
            "\"results\": [\n" +
            "{\n" +
            "\"id\": \"0\",\n" +
            "\"question\": \"In the Doctor Who universe, how many times can a time lord normally regenerate?\",\n" +
            "\"correct_answer\": \"12\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"11\",\n" +
            "\"13\",\n" +
            "\"12\",\n" +
            "\"15\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"1\",\n" +
            "\"question\": \"Which track by Massive Attack is used for the theme of House? \",\n" +
            "\"correct_answer\": \"Teardrop\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Protection\",\n" +
            "\"Teardrop\",\n" +
            "\"Angel\",\n" +
            "\"Black Milk\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"2\",\n" +
            "\"question\": \"Which character does voice actress Tara Strong NOT voice?\",\n" +
            "\"correct_answer\": \"Bubbles (2016)\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Twilight Sparkle\",\n" +
            "\"Timmy Turner\",\n" +
            "\"Harley Quinn\",\n" +
            "\"Bubbles (2016)\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"3\",\n" +
            "\"question\": \"In Naruto: Shippuden, which of the following elements is a Kekkei Tōta?\",\n" +
            "\"correct_answer\": \"Particle Style\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Any Doujutsu\",\n" +
            "\"Shadow Style\",\n" +
            "\"Particle Style\",\n" +
            "\"Ice Style\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"4\",\n" +
            "\"question\": \"Who was the winner of the 2016 WWE Royal Rumble?\",\n" +
            "\"correct_answer\": \"Triple H\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Triple H\",\n" +
            "\"Roman Reigns\",\n" +
            "\"AJ Styles\",\n" +
            "\"Dean Ambrose\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"5\",\n" +
            "\"question\": \"What is Megan's full name in Family Guy\",\n" +
            "\"correct_answer\": \"Megatron Griffin\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Who-Cares Griffin\",\n" +
            "\"Neil Griffin\",\n" +
            "\"Megan Griffin\",\n" +
            "\"Megatron Griffin\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"6\",\n" +
            "\"question\": \"Which of following is rude and dishonorable by Klingon standards?\",\n" +
            "\"correct_answer\": \"Taking his tahg\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Insulting and laughing at him at the dinner table\",\n" +
            "\"Reaching over and taking his meal\",\n" +
            "\"Taking his tahg\",\n" +
            "\"Punching him and taking his ship station position\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"7\",\n" +
            "\"question\": \"What episode of Mr. Bean saw him trying to prevent people from seeing him naked?\",\n" +
            "\"correct_answer\": \"Mr. Bean in Room 426\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Mr. Bean Goes to Town\",\n" +
            "\"Mr. Bean in Room 426\",\n" +
            "\"The Trouble with Mr. Bean\",\n" +
            "\"Back to School Mr. Bean\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"8\",\n" +
            "\"question\": \"Alan Reed is known for providing the voice of which character?\",\n" +
            "\"correct_answer\": \"Fred Flintstone\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Fred Flintstone\",\n" +
            "\"Bugs Bunny\",\n" +
            "\"Fangface\",\n" +
            "\"G.I. Joe\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"9\",\n" +
            "\"question\": \"In Battlestar Galactica (2004), what is the name of the President of the Twelve Colonies?\",\n" +
            "\"correct_answer\": \"Laura Roslin\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"William Adama\",\n" +
            "\"Tricia Helfer\",\n" +
            "\"Laura Roslin\",\n" +
            "\"Harry Stills\"\n" +
            "]\n" +
            "}\n" +
            "]\n" +
            "}";

    public static String levelFiveQuestions = "{\n" +
            "\"results\": [\n" +
            "{\n" +
            "\"id\": \"0\",\n" +
            "\"question\": \"Which popular First Person Shooter (FPS) franchise, got a Real Time Strategy (RTS) game developed based on its universe?\",\n" +
            "\"correct_answer\": \"Halo\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Battlefield\",\n" +
            "\"Call of Duty\",\n" +
            "\"Halo\",\n" +
            "\"Borderlands\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"1\",\n" +
            "\"question\": \"Who is Sonic's sidekick?\",\n" +
            "\"correct_answer\": \"Tails\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Shadow\",\n" +
            "\"Amy\",\n" +
            "\"Tails\",\n" +
            "\"Knuckles\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"2\",\n" +
            "\"question\": \"Who is the main character of the game Half-Life: Opposing Force?\",\n" +
            "\"correct_answer\": \"Adrian Shephard\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Adrian Shephard\",\n" +
            "\"Gordon Freeman\",\n" +
            "\"Alyx Vance\",\n" +
            "\"Barney Calhoun\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"3\",\n" +
            "\"question\": \"What was the first video game in the Batman Arkham series?\",\n" +
            "\"correct_answer\": \"Arkham Asylum\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Arkham Knight\",\n" +
            "\"Arkham City\",\n" +
            "\"Arkham Asylum\",\n" +
            "\"Arkham Origins\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"4\",\n" +
            "\"question\": \"In what year was Metal Gear Solid released in North America?\",\n" +
            "\"correct_answer\": \"1998\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"1998\",\n" +
            "\"1987\",\n" +
            "\"2001\",\n" +
            "\"2004\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"5\",\n" +
            "\"question\": \"In most FPS video games such as Counter-Strike, shooting which part of the body does the highest damage?\",\n" +
            "\"correct_answer\": \"Head\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Arm\",\n" +
            "\"Head\",\n" +
            "\"Leg\",\n" +
            "\"Chest\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"6\",\n" +
            "\"question\": \"Which of these Starbound races has a Wild West culture?\",\n" +
            "\"correct_answer\": \"Novakid\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Avian\",\n" +
            "\"Human\",\n" +
            "\"Novakid\",\n" +
            "\"Hylotl\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"7\",\n" +
            "\"question\": \"What is the first weapon you acquire in Half-Life?\",\n" +
            "\"correct_answer\": \"A crowbar\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"A pistol\",\n" +
            "\"The H.E.V suit\",\n" +
            "\"Your fists\",\n" +
            "\"A crowbar\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"8\",\n" +
            "\"question\": \"Who are the original creators of Rachet Clank?\",\n" +
            "\"correct_answer\": \"Insomniac Games\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Insomniac Games\",\n" +
            "\"PixelTail Games\",\n" +
            "\"Rare\",\n" +
            "\"Bethesda\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "\"id\": \"9\",\n" +
            "\"question\": \"Which Elite Four member from the first generation of Pokemon became the champion in the next generation?\",\n" +
            "\"correct_answer\": \"Lance\",\n" +
            "\"incorrect_answers\": [\n" +
            "\"Agatha\",\n" +
            "\"Lance\",\n" +
            "\"Bruno\",\n" +
            "\"Lorelei\"\n" +
            "]\n" +
            "}\n" +
            "]\n" +
            "}";

}
