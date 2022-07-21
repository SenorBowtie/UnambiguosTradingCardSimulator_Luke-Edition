package net.SenorBowtie;

import javax.lang.model.type.DeclaredType;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        String StadiumDisplay;

        List<String> DeckFront = new ArrayList<>();
        List<String> Stadium = new ArrayList<>();
        List<String> Active = new ArrayList<>();
        List<String> Bench = new ArrayList<>();
        List<String> DeckBack = new ArrayList<>();
        List<String> Hand = new ArrayList<>();
        List<String> Discard = new ArrayList<>();
        List<String> PrizeCards = new ArrayList<>();
        List<String> Deck = new ArrayList<>();
        Map<String,String> PokemonNickname = new HashMap<>();
        Map<String,Boolean> IsStadium = new HashMap<>();
        Map<String,Boolean> IsEnergyOrTool = new HashMap<>();
        Map<String,String> PokemonEvolvesFrom = new HashMap<>();
        Map<String,List<String>> AttachedCards = new HashMap<>();
        Boolean DeckConfirmed = false;
        while (!DeckConfirmed) {
            System.out.println("Would you like to use one of the premade decks or Register one of your own? (Premade or Register)");
            String PremadeOrRegister = Input.next();
            if(PremadeOrRegister.equalsIgnoreCase("premade")){
                System.out.println("Which deck would you like to use?");
                System.out.println("1: PsychicGLC");
                //Enter New Option Line Above Here
                int DeckChoice = Input.nextInt();
                switch (DeckChoice){
                    case 1:
                        PsychicGLCRegister(Deck, PokemonNickname, AttachedCards, PokemonEvolvesFrom, IsStadium, IsEnergyOrTool);
                        DeckConfirmed = true;
                        break;
                    // Add Case Line Above Here
                    case 420:
                        break;
                    default:
                        System.out.println("There is not a deck associated with that number.");
                        break;
                }
            } else if (PremadeOrRegister.equalsIgnoreCase("register")) {
                Map<Integer, String> CardNumberToCardType = new HashMap<>();
                Map<Integer, String> CardNumberToCardName = new HashMap<>();
                Map<Integer, String> CardNumberToCardNickName = new HashMap<>();
                Map<Integer, String> CardNumberToPreevolution = new HashMap<>();
                String DeckName;
                System.out.println("Let's get started in registering 60 cards ");
                while(Deck.size()<60){
                    int CardNumber = Deck.size()+1;
                    System.out.println("Card "+CardNumber+":");
                    System.out.println("Is it either a Pokemon, Tool, Stadium, or Energy? (Y or N)");
                    String PTEYOrN = Input.next();
                    if(PTEYOrN.equalsIgnoreCase("y")){
                        while (true){
                            System.out.println("What type of Card is it? (Pokemon, Tool, Stadium, Energy, or Return)");
                            String CardType = Input.next();
                            if (CardType.equalsIgnoreCase("pokemon")){
                                while (true){
                                    System.out.println("What is the name of the card?");
                                    String Fake = Input.nextLine();
                                    String CardName = Input.nextLine();
                                    System.out.println("What is a 3-4 letter shorthand for this pokemon.");
                                    String CardNickName = Input.next();
                                    System.out.println("Card "+CardNumber+" will be called "+CardName+". It will be referred to as "+CardNickName+" on the bench. Is this OK? (Y or N or Return)");
                                    String NameConfirm = Input.next();
                                    if(NameConfirm.equalsIgnoreCase("y")){
                                        while (true) {
                                            System.out.println("Is it a basic pokemon? (Y or N)");
                                            String IsBasic = Input.next();
                                            if (IsBasic.equalsIgnoreCase("y")) {
                                                System.out.println("How many " + CardName + "s would you like in your deck? (Min 1 - Max 4)");
                                                int CardAmount = Input.nextInt();
                                                if (CardAmount >= 1) {
                                                    if (CardAmount <= 4) {
                                                        for (int i = 0; i < CardAmount; i++) {
                                                            CardNumberToCardName.put(Deck.size(), CardName);
                                                            CardNumberToCardType.put(Deck.size(), "Pokemon");
                                                            CardNumberToCardNickName.put(Deck.size(),CardNickName);
                                                            CardNumberToPreevolution.put(Deck.size(), "Basic");
                                                            Deck.add(CardName);
                                                            int X = Deck.size()-1;
                                                            PokemonNickname.put(Deck.get(X),CardNickName);
                                                            AttachedCards.put(Deck.get(X), new ArrayList<>());
                                                            PokemonEvolvesFrom.put(Deck.get(X),"Basic");
                                                            System.out.println(CardName + " was added to your deck.");
                                                        }
                                                        break;
                                                    } else if (CardAmount == 420) {
                                                        break;
                                                    } else {
                                                        System.out.println("That number is too big.");
                                                    }
                                                } else {
                                                    System.out.println("That number is too small.");
                                                }
                                            }else if(IsBasic.equalsIgnoreCase("n")){
                                                while (true){
                                                    System.out.println("What Pokemon does it evolve from? (Case Sensitive: Make sure to spell it the same way you put it in.)");
                                                    String FakePokemon = Input.nextLine();
                                                    String PreevolutionName = Input.nextLine();
                                                    System.out.println(CardName+" will evolve from "+PreevolutionName+". Is that ok? (Y or N)");
                                                    String PreevolutionCheck = Input.next();
                                                    if(PreevolutionCheck.equalsIgnoreCase("y")){
                                                        System.out.println("How many " + CardName + "s would you like in your deck? (Min 1 - Max 4)");
                                                        int CardAmount = Input.nextInt();
                                                        if (CardAmount >= 1) {
                                                            if (CardAmount <= 4) {
                                                                for (int i = 0; i < CardAmount; i++) {
                                                                    CardNumberToCardName.put(Deck.size(), CardName);
                                                                    CardNumberToCardType.put(Deck.size(), "Pokemon");
                                                                    CardNumberToCardNickName.put(Deck.size(),CardNickName);
                                                                    CardNumberToPreevolution.put(Deck.size(), PreevolutionName);
                                                                    Deck.add(CardName);
                                                                    int X = Deck.size()-1;
                                                                    PokemonNickname.put(Deck.get(X),CardNickName);
                                                                    AttachedCards.put(Deck.get(X), new ArrayList<>());
                                                                    PokemonEvolvesFrom.put(Deck.get(X),PreevolutionName);
                                                                    System.out.println(CardName + " was added to your deck.");
                                                                }
                                                                break;
                                                            } else if (CardAmount == 420) {
                                                                break;
                                                            } else {
                                                                System.out.println("That number is too big.");
                                                            }
                                                        } else {
                                                            System.out.println("That number is too small.");
                                                        }
                                                    }
                                                }
                                                break;
                                            }else{
                                                System.out.println("Not a freaking option.");
                                            }
                                        }
                                        break;
                                    } else if (NameConfirm.equalsIgnoreCase("return")) {
                                        break;
                                    }
                                }
                                break;
                            }else if (CardType.equalsIgnoreCase("tool")){
                                while (true){
                                    System.out.println("What is the name of the card?");
                                    String Fake = Input.nextLine();
                                    String CardName = Input.nextLine();
                                    System.out.println("Card "+CardNumber+" will be called "+CardName+". Is this OK? (Y or N or Return)");
                                    String NameConfirm = Input.next();
                                    if(NameConfirm.equalsIgnoreCase("y")){
                                        while (true) {
                                            System.out.println("How many " + CardName + "s would you like in your deck? (Min 1 - Max 4)");
                                            int CardAmount = Input.nextInt();
                                            if (CardAmount >=1) {
                                                if (CardAmount <=4) {
                                                    for(int i=0;i<CardAmount;i++){
                                                        CardNumberToCardName.put(Deck.size(), CardName);
                                                        CardNumberToCardType.put(Deck.size(), "EnergyOrTool");
                                                        Deck.add(CardName);
                                                        int X=Deck.size()-1;
                                                        IsEnergyOrTool.put(Deck.get(X),true);
                                                        System.out.println(CardName+" was added to your deck.");
                                                    }
                                                    break;
                                                }else if(CardAmount==420) {
                                                    break;
                                                }else{
                                                    System.out.println("That number is too big.");
                                                }
                                            } else {
                                                System.out.println("That number is too small.");
                                            }
                                        }
                                        break;
                                    } else if (NameConfirm.equalsIgnoreCase("return")) {
                                        break;
                                    }
                                }break;
                            }else if (CardType.equalsIgnoreCase("stadium")){
                                while (true){
                                    System.out.println("What is the name of the card?");
                                    String Fake = Input.nextLine();
                                    String CardName = Input.nextLine();
                                    System.out.println("Card "+CardNumber+" will be called "+CardName+". Is this OK? (Y or N or Return)");
                                    String NameConfirm = Input.next();
                                    if(NameConfirm.equalsIgnoreCase("y")){
                                        while (true) {
                                            System.out.println("How many " + CardName + "s would you like in your deck? (Min 1 - Max 4)");
                                            int CardAmount = Input.nextInt();
                                            if (CardAmount >=1) {
                                                if (CardAmount <=4) {
                                                    for(int i=0;i<CardAmount;i++){
                                                        CardNumberToCardName.put(Deck.size(), CardName);
                                                        CardNumberToCardType.put(Deck.size(), "Stadium");
                                                        Deck.add(CardName);
                                                        int X=Deck.size()-1;
                                                        IsStadium.put(Deck.get(X),true);
                                                        System.out.println(CardName+" was added to your deck.");
                                                    }
                                                    break;
                                                }else if(CardAmount==420) {
                                                    break;
                                                }else{
                                                    System.out.println("That number is too big.");
                                                }
                                            } else {
                                                System.out.println("That number is too small.");
                                            }
                                        }
                                        break;
                                    } else if (NameConfirm.equalsIgnoreCase("return")) {
                                        break;
                                    }
                                }break;
                            }else if (CardType.equalsIgnoreCase("energy")){
                                while (true){
                                    System.out.println("What is the name of the card?");
                                    String Fake = Input.nextLine();
                                    String CardName = Input.nextLine();
                                    System.out.println("Card "+CardNumber+" will be called "+CardName+". Is this OK? (Y or N or Return)");
                                    String NameConfirm = Input.next();
                                    if(NameConfirm.equalsIgnoreCase("y")){
                                        while (true) {
                                            int CardsLeft = 60-Deck.size();
                                            System.out.println("How many " + CardName + "s would you like in your deck? (Min 1 - Max "+CardsLeft+")");
                                            int CardAmount = Input.nextInt();
                                            if (CardAmount >=1) {
                                                if (CardAmount <=CardsLeft) {
                                                    for(int i=0;i<CardAmount;i++){
                                                        CardNumberToCardName.put(Deck.size(), CardName);
                                                        CardNumberToCardType.put(Deck.size(), "EnergyOrTool");
                                                        Deck.add(CardName);
                                                        int X=Deck.size()-1;
                                                        IsEnergyOrTool.put(Deck.get(X),true);
                                                        System.out.println(CardName+" was added to your deck.");
                                                    }
                                                    break;
                                                }else if(CardAmount==420) {
                                                    break;
                                                }else{
                                                    System.out.println("That number is too big.");
                                                }
                                            } else {
                                                System.out.println("That number is too small.");
                                            }
                                        }
                                        break;
                                    } else if (NameConfirm.equalsIgnoreCase("return")) {
                                        break;
                                    }
                                }break;
                            }else if (CardType.equalsIgnoreCase("return")){
                                break;
                            }else{
                                System.out.println("That's not a valid card type.");
                            }
                        }
                    }else if(PTEYOrN.equalsIgnoreCase("n")){
                        while (true){
                            System.out.println("What is the name of the card?");
                            String Fake = Input.nextLine();
                            String CardName = Input.nextLine();
                            System.out.println("Card "+CardNumber+" will be called "+CardName+". Is this OK? (Y or N or Return)");
                            String NameConfirm = Input.next();
                            if(NameConfirm.equalsIgnoreCase("y")){
                                while (true) {
                                    System.out.println("How many " + CardName + "s would you like in your deck? (Min 1 - Max 4)");
                                    int CardAmount = Input.nextInt();
                                    if (CardAmount >=1) {
                                        if (CardAmount <=4) {
                                            for(int i=0;i<CardAmount;i++){
                                                CardNumberToCardName.put(Deck.size(), CardName);
                                                CardNumberToCardType.put(Deck.size(), "Other");
                                                Deck.add(CardName);
                                                System.out.println(CardName+" was added to your deck.");
                                            }
                                            break;
                                        }else if(CardAmount==420) {
                                            break;
                                        }else{
                                                System.out.println("That number is too big.");
                                        }
                                    } else {
                                        System.out.println("That number is too small.");
                                    }
                                }
                                break;
                            } else if (NameConfirm.equalsIgnoreCase("return")) {
                                break;
                            }
                        }
                    }else{
                        System.out.println("Bruh. Y or N. Try Again.");
                    }
                }
                System.out.println("And Finally...");
                while (true){
                    System.out.println("What would you like to name your deck? (Must be 1 word)");
                    DeckName = Input.next();
                    System.out.println("Your Deck will be called "+DeckName+". Would you like to continue? (Y or N)");
                    String FinalizeDeckName = Input.next();
                    if(FinalizeDeckName.equalsIgnoreCase("y")){
                        System.out.println("Deck has been named.");
                        break;
                    }
                }
                DeckConfirmed=true;
                while(true){
                    System.out.println("Would you like to get the code and instructions to make this deck show up on the Premade Decks list? (Y or N)");
                    String GetCodeConfirm = Input.next();
                    if(GetCodeConfirm.equalsIgnoreCase("y")){
                        System.out.println("//Here's the code to plug in to line 1785. Copy and paste it starting with the line below.");
                        System.out.println("private static void "+DeckName+"(List<String> Deck, Map<String, String> PokemonNickname, Map<String, List<String>> AttachedCards, Map<String,String> PokemonEvolvesFrom, Map<String,Boolean> IsStadium, Map<String,Boolean> IsToolOrEnergy) {");
                        System.out.println("int X;");
                        for(int i=0; i<60;i++){
                            if(CardNumberToCardType.getOrDefault(i,"Default").equalsIgnoreCase("Pokemon")){
                                System.out.println("Deck.add(\""+CardNumberToCardName.get(i)+"\");");
                                System.out.println("X = Deck.size()-1;");
                                System.out.println("PokemonNickname.put(Deck.get(X),\""+CardNumberToCardNickName.get(i)+"\");");
                                System.out.println("AttachedCards.put(Deck.get(X), new ArrayList<>());");
                                System.out.println("PokemonEvolvesFrom.put(Deck.get(X),\""+CardNumberToPreevolution.get(i)+"\");");
                            }else if(CardNumberToCardType.getOrDefault(i,"Default").equalsIgnoreCase("EnergyOrTool")){
                                System.out.println("Deck.add(\""+CardNumberToCardName.get(i)+"\");");
                                System.out.println("X = Deck.size()-1;");
                                System.out.println("IsToolOrEnergy.put(Deck.get(X),true);");
                            }else if(CardNumberToCardType.getOrDefault(i,"Default").equalsIgnoreCase("Stadium")){
                                System.out.println("Deck.add(\""+CardNumberToCardName.get(i)+"\");");
                                System.out.println("X = Deck.size()-1;");
                                System.out.println("IsStadium.put(Deck.get(X),true);");
                            }else if(CardNumberToCardType.getOrDefault(i,"Default").equalsIgnoreCase("Other")){
                                System.out.println("Deck.add(\""+CardNumberToCardName.get(i)+"\");");
                            }else if(CardNumberToCardType.getOrDefault(i,"Default").equalsIgnoreCase("Default")){
                                System.out.println("Deck.add(\""+CardNumberToCardName.get(i)+"\");");
                                System.out.println("// This Card was not labelled with a type. If it is supposed to it will not work like normal.");
                            }
                        }
                        System.out.println("}");
                        System.out.println("");
                        System.out.println("// This is not included with the code The last line was one above.");
                        System.out.println("// Copy and paste this code at the very bottom after the last line of all of the code.");
                        System.out.println("");
                        System.out.println("Type \"Confirm\" when you are ready for the next line of code.");
                        while (true){
                            String Confirm1 = Input.next();
                            if (Confirm1.equalsIgnoreCase("confirm")){
                                break;
                            }
                        }
                        System.out.println("//Here's the New Case line code to plug in near line 40. Copy and paste it starting with the line below.");
                        System.out.println("case XX:");
                        System.out.println(DeckName+"(Deck, PokemonNickname, AttachedCards, PokemonEvolvesFrom, IsStadium, IsEnergyOrTool);");
                        System.out.println("DeckConfirmed = true;");
                        System.out.println("break;");
                        System.out.println("");
                        System.out.println("// This is not included into the code the last line was one above. Make sure to replace the XX in the case function with a unique number.");
                        System.out.println("");
                        System.out.println("Type \"Confirm\" when you are ready for the next line of code.");
                        while (true){
                            String Confirm2 = Input.next();
                            if (Confirm2.equalsIgnoreCase("confirm")){
                                break;
                            }
                        }
                        System.out.println("//One last line of code left and is listed below. Place the New Option Line Code near line 33");
                        System.out.println("System.out.println(\"XX: "+DeckName+"\");");
                        System.out.println("");
                        System.out.println("// This is not included into the code the last line was one above. Make sure to replace the XX to match the case function as used earlier.");
                        System.out.println("");
                        System.out.println("Type \"Confirm\" when you are finished plugging in all the code.");
                        while (true){
                            String Confirm3 = Input.next();
                            if (Confirm3.equalsIgnoreCase("confirm")){
                                break;
                            }
                        }
                    } else if (GetCodeConfirm.equalsIgnoreCase("n")) {
                        break;
                    }else {
                        System.out.println("Sorry I didn't get that.");
                    }
                }
            }else{

            }
        }

        HardShuffleDeck(DeckFront,DeckBack,Deck);
        HardShuffleDeck(DeckFront,DeckBack,Deck);
        Boolean PrizeCardsRevealed = false;
        int MaxBenchSize = 5;
        TakeFromDeck(DeckFront,Deck,DeckBack,Hand,"Your Hand",7);
        while (true) {
            int MulliganCounter = 0;
            System.out.println("Do you have a basic pokemon? (Y or N)");
            String YorN = Input.next();
            if(YorN.equals("Y")){
                while (true){
                    PrintList(Hand,"Your Hand");
                    System.out.println("Choose your active pokemon! (Int required");
                    int FirstActive = Input.nextInt();
                    if(FirstActive<= Hand.size()) {
                        MovePokemonIntoPlay(Hand, FirstActive, Active, "Your Active Spot", true, PokemonEvolvesFrom, MaxBenchSize, AttachedCards);
                        if (Active.size() == 1) {
                            break;
                        } else {
                            continue;
                        }
                    }else {
                        System.out.println("You don't have that card in Your Hand!");
                        continue;
                    }
                }
                while (true) {
                    System.out.println("Would you like to add a pokemon to your bench?");
                    String YorN2 = Input.next();
                    if (YorN2.equals("Y")) {
                        PrintList(Hand,"Your Hand");
                        System.out.println("Choose your pokemon for the bench! (Int required");
                        int NextBench = Input.nextInt();
                        if(NextBench<=Hand.size()) {
                            MovePokemonIntoPlay(Hand, NextBench, Bench, "Your Bench", false, PokemonEvolvesFrom, MaxBenchSize, AttachedCards);
                            continue;
                        }else{
                            System.out.println("You don't have that card in Your Hand!");
                            continue;
                        }
                    }else if (YorN2.equals("N")){
                        System.out.println("Looks like we are almost done then!");
                        break;
                    }else{
                        System.out.println("Sorry I didn't get that. Try again!");
                        continue;
                    }
                }
                break;
            } else if (YorN.equals("N")) {
                TakeFromDeckSilent(Hand,Deck,DeckBack,Deck,"Your Deck",Hand.size());
                TakeFromDeck(DeckFront,Deck,DeckBack,Hand,"Your Hand",7);
                MulliganCounter++;
                continue;
            }else{
                System.out.println("Sorry I didn't get that. Try again!");
                continue;
            }
        }
        TakeFromDeckSilent(DeckFront,Deck,DeckBack,PrizeCards,"Your Prize Cards",6);
        PrintActiveAndBench(Active,Bench,PokemonNickname,MaxBenchSize,AttachedCards);
        System.out.println("This is your current set up!");

        while (true){
            System.out.println("What would you like to do? (Type 'Help' for Help)");
            String NextMove = Input.next();
            if(NextMove.toLowerCase().equals("help")){
                System.out.println("Here's a list of commands and what they do!");
                System.out.println("Draw: Put a card from somewhere into your hand!");
                System.out.println("Discard: Discard a card from somewhere");
                System.out.println("MoveCard: Move a card to and from somewhere");
                System.out.println("MovePokemon: Move a Pokemon card in and out of play or switch your active with your bench");
                System.out.println("AttachCard: Move an Energy or an Item Tool onto a pokemon, or remove and attach card.");
                System.out.println("ChangeStatus: Change the status of certain triggers in the game");
            }
            if(NextMove.toLowerCase().equals("draw")){
                while (true){
                    System.out.println("Where would you like to draw from? (Deck or PrizeCards)");
                    String DeckOrPrize = Input.next();
                    if(DeckOrPrize.toLowerCase().equals("deck")){
                        System.out.println("How many would you like to draw? (Int)");
                        int DrawAmount = Input.nextInt();
                        TakeFromDeck(DeckFront,Deck,DeckBack,Hand,"Your Hand",DrawAmount);
                        break;
                    } else if (DeckOrPrize.toLowerCase().equals("prizecards")) {
                        System.out.println("How many would you like to draw? (Int)");
                        int DrawAmount = Input.nextInt();
                        if(PrizeCardsRevealed){
                            for(int i=0;i<DrawAmount;i++) {
                                System.out.println("Here are your Prize Cards. Which would you like?");
                                PrintList(PrizeCards, "Your Prize Cards");
                                int SpecificCard = Input.nextInt();
                                MoveCard(PrizeCards,Hand,"Your Hand",SpecificCard);
                                break;
                            }
                        }else{
                            System.out.println("Do you care which card(s) you grab? (Y or N)");
                            String SpecificGrab = Input.next();
                            if(SpecificGrab.equals("Y")){
                                for(int i=0;i<DrawAmount;i++){
                                    System.out.println("There are "+PrizeCards.size()+" Prize Cards left. Which one would you like?");
                                    int SpecificCard = Input.nextInt();
                                    MoveCard(PrizeCards,Hand,"Your Hand",SpecificCard);
                                }
                                break;
                            } else if (SpecificGrab.equals("N")) {
                                TakeFromDeck(PrizeCards,PrizeCards,PrizeCards,Hand,"Your Hand",DrawAmount);
                                break;
                            }
                        }
                    }
                }
            }else if(NextMove.toLowerCase().equals("discard")){
                System.out.println("Where would you like to discard from? (Hand, PrizeCards, Deck)");
                String DiscardFrom = Input.next();
                    if(DiscardFrom.equals("Hand")){
                        CheckOriginToMoveCard(Hand,"Your Hand", "Which card would you like to Discard?", Input, Discard, "Your Discard Pile");
                    } else if (DiscardFrom.equals("PrizeCards")) {
                        while(true) {
                            System.out.println("How many would you like to discard?");
                            int DrawAmount = Input.nextInt();
                            if (DrawAmount <= PrizeCards.size()) {
                                if (PrizeCardsRevealed) {
                                    for (int i = 0; i < DrawAmount; i++) {
                                        System.out.println("Here are your Prize Cards. Which would you like to discard?");
                                        PrintList(PrizeCards, "Your Prize Cards");
                                        int SpecificCard = Input.nextInt();
                                        MoveCard(PrizeCards, Discard, "Your Discard Pile", SpecificCard);
                                        break;
                                    }
                                } else {
                                    System.out.println("Do you care which card(s) you discard? (Y or N)");
                                    String SpecificGrab = Input.next();
                                    if (SpecificGrab.equals("Y")) {
                                        for (int i = 0; i < DrawAmount; i++) {
                                            System.out.println("There are " + PrizeCards.size() + " Prize Cards left. Which one would you like to discard?");
                                            int SpecificCard = Input.nextInt();
                                            MoveCard(PrizeCards, Discard, "Your Discard Pile", SpecificCard);
                                        }
                                        break;
                                    } else if (SpecificGrab.equals("N")) {
                                        TakeFromDeck(PrizeCards, PrizeCards, PrizeCards, Discard, "Your Discard Pile", DrawAmount);
                                        break;
                                    }
                                }
                            }else if(DrawAmount==420){
                                break;
                            }else{
                                System.out.println("You don't have that many Prize Cards left.");
                                continue;
                            }
                        }
                    } else if (DiscardFrom.equals("Deck")) {
                        while(true) {
                            int DeckTotal = DeckFront.size()+ Deck.size()+ DeckBack.size();
                            System.out.println("How many would you like to discard?");
                            int DiscardAmount = Input.nextInt();
                            if (DiscardAmount <= DeckTotal) {
                                TakeFromDeck(DeckFront, Deck, DeckBack, Discard, "Your Discard Pile", DiscardAmount);
                                break;
                            }else if(DiscardAmount==420){
                                break;
                            }else{
                                System.out.println("You don't have that many cards left in Your Deck.");
                                System.out.println("Would you like to Discard the rest?");
                                String DiscardRest = Input.next();
                                if (DiscardRest.toLowerCase().equals("y")){
                                    int DeckTotal2 = DeckFront.size()+Deck.size()+DeckBack.size();
                                    TakeFromDeckSilent(DeckFront,Deck,DeckBack,Discard,"Your Discard Pile",DeckTotal2);
                                    break;
                                }else{
                                    continue;
                                }
                            }
                        }
                    }
            } else if (NextMove.toLowerCase().equals("movecard")) {
                System.out.println("Where would you like to move the card from? (Hand, Deck, Discard, PrizeCards, or Stadium)");
                String CardFrom = Input.next();
                System.out.println("Where would you like to move the card to? (Hand, Deck, Discard, PrizeCards, or Stadium)" );
                String CardTo = Input.next();
                while(true) {
                    if (CardFrom.toLowerCase().equals("hand")) {
                        if (CardTo.toLowerCase().equals("deck")){
                            System.out.println("Where in the deck would you like it? (Front, Deck, Back, or Return)");
                            String DeckLocation = Input.next();
                            if(DeckLocation.toLowerCase().equals("front")){
                                CheckOriginToMoveCard(Hand,"Your Hand", "Which would you like to add on top of Your Deck?", Input, DeckFront, "The Front of the Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("deck")) {
                                CheckOriginToMoveCard(Hand, "Your Hand","Which would you like to Your Deck?", Input, Deck, "Your Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("back")) {
                                CheckOriginToMoveCard(Hand, "Your Hand","Which would you like to to the bottom of Your Deck?", Input, DeckBack, "the Bottom of Your Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("return")) {
                                break;
                            }else{
                                System.out.println("Not a valid deck location.");
                                continue;
                            }
                        } else if (CardTo.toLowerCase().equals("discard")) {
                            CheckOriginToMoveCard(Hand, "Your Hand","Which would you like to Discard?", Input, Discard, "Your Discard Pile");
                            break;
                        } else if (CardTo.toLowerCase().equals("prizecards")) {
                            CheckOriginToMoveCard(Hand, "Your Hand","Which would you like to add to your Prize Cards?", Input, PrizeCards, "Your Prize Cards");
                            break;
                        } else if (CardTo.toLowerCase().equals("stadium")) {
                            CheckBooleanToMoveCard(Input, Hand,"Your Hand", IsStadium, Stadium, "Your Stadium");
                            break;
                        }else{
                            System.out.println("Not a valid location");
                        }
                    }else if(CardFrom.toLowerCase().equals("deck")){
                        if (CardTo.toLowerCase().equals("hand")){
                            CheckDeckToMoveCard(Input, DeckFront, Deck, DeckBack, Hand,"Your Hand",false,IsStadium);
                            break;
                        } else if (CardTo.toLowerCase().equals("discard")) {
                            CheckDeckToMoveCard(Input,DeckFront,Deck,DeckBack,Discard,"Your Discard Pile",false,IsStadium);
                            break;
                        } else if (CardTo.toLowerCase().equals("prizecards")) {
                            CheckDeckToMoveCard(Input,DeckFront,Deck,DeckBack,PrizeCards,"Your Prize Cards",false,IsStadium);
                            break;
                        } else if (CardTo.toLowerCase().equals("stadium")) {
                            CheckDeckToMoveCard(Input,DeckFront,Deck,DeckBack,Stadium,"Your Stadium Spot",true,IsStadium);
                            break;
                        }else{
                            System.out.println("Not a valid location");
                        }
                    } else if (CardFrom.toLowerCase().equals("discard")) {
                        if(CardTo.toLowerCase().equals("hand")){
                            CheckOriginToMoveCard(Discard,"Your Discard Pile","Which Card would you like to add to Your Hand?",Input,Hand,"Your Hand");
                            break;
                        }else if(CardTo.toLowerCase().equals("deck")){
                            System.out.println("Where in the deck would you like it? (Front, Deck, Back, or Return)");
                            String DeckLocation = Input.next();
                            if(DeckLocation.toLowerCase().equals("front")){
                                CheckOriginToMoveCard(Discard,"Your Discard Pile", "Which would you like to add on top of Your Deck?", Input, DeckFront, "The Front of the Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("deck")) {
                                CheckOriginToMoveCard(Discard,"Your Discard Pile","Which would you like to Your Deck?", Input, Deck, "Your Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("back")) {
                                CheckOriginToMoveCard(Discard,"Your Discard Pile","Which would you like to to the bottom of Your Deck?", Input, DeckBack, "the Bottom of Your Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("return")) {
                                break;
                            }else{
                                System.out.println("Not a valid deck location.");
                                continue;
                            }
                        } else if (CardTo.toLowerCase().equals("prizecards")) {
                            CheckOriginToMoveCard(Discard,"Your Discard Pile", "Which card would you like to add to Your Prize Cards?",Input,PrizeCards,"Your Prize Cards");
                            break;
                        }else if (CardTo.toLowerCase().equals("stadium")) {
                            CheckBooleanToMoveCard(Input,Discard,"Your Discard Pile",IsStadium,Stadium,"Your Stadium Spot");
                            break;
                        }else{
                            System.out.println("Not a valid location");
                        }
                    } else if (CardFrom.toLowerCase().equals("prizecards")) {
                        if(CardTo.toLowerCase().equals("hand")){
                            CheckOriginToMoveCard(PrizeCards,"Your Prize Cards", "Which card would you like to add to your hand?",Input,Hand,"Your Hand");
                            break;
                        } else if (CardTo.toLowerCase().equals("discard")) {
                            CheckOriginToMoveCard(PrizeCards,"Your Prize Cards", "Which card would you like to discard?", Input, Discard,"Your Discard Pile");
                            break;
                        } else if (CardTo.toLowerCase().equals("deck")) {
                            System.out.println("Where in the deck would you like it? (Front, Deck, Back, or Return)");
                            String DeckLocation = Input.next();
                            if(DeckLocation.toLowerCase().equals("front")){
                                CheckOriginToMoveCard(PrizeCards,"Your Prize Cards", "Which would you like to add on top of Your Deck?", Input, DeckFront, "The Front of the Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("deck")) {
                                CheckOriginToMoveCard(PrizeCards,"Your Prize Cards","Which would you like to Your Deck?", Input, Deck, "Your Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("back")) {
                                CheckOriginToMoveCard(PrizeCards,"Your Prize Cards","Which would you like to to the bottom of Your Deck?", Input, DeckBack, "the Bottom of Your Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("return")) {
                                break;
                            }else{
                                System.out.println("Not a valid deck location.");
                                continue;
                            }
                        }else if (CardTo.toLowerCase().equals("stadium")) {
                            CheckBooleanToMoveCard(Input,PrizeCards,"Your Prize Cards",IsStadium,Stadium,"Your Stadium Spot");
                            break;
                        }else{
                            System.out.println("Not a valid location");
                        }
                    } else  if (CardFrom.toLowerCase().equals("stadium")) {
                        if (CardTo.toLowerCase().equals("deck")){
                            System.out.println("Where in the deck would you like it? (Front, Deck, Back, or Return)");
                            String DeckLocation = Input.next();
                            if(DeckLocation.toLowerCase().equals("front")){
                                CheckOriginToMoveCard(Stadium, "Your Stadium Spot", "Which would you like to add on top of Your Deck?", Input, DeckFront, "The Front of the Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("deck")) {
                                CheckOriginToMoveCard(Stadium, "Your Stadium Spot","Which would you like to Your Deck?", Input, Deck, "Your Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("back")) {
                                CheckOriginToMoveCard(Stadium, "Your Stadium Spot","Which would you like to to the bottom of Your Deck?", Input, DeckBack, "the Bottom of Your Deck");
                                break;
                            } else if (DeckLocation.toLowerCase().equals("return")) {
                                break;
                            }else{
                                System.out.println("Not a valid deck location.");
                                continue;
                            }
                        } else if (CardTo.toLowerCase().equals("discard")) {
                            CheckOriginToMoveCard(Stadium, "Your Stadium Spot","Which would you like to Discard?", Input, Discard, "Your Discard Pile");
                            break;
                        } else if (CardTo.toLowerCase().equals("prizecards")) {
                            CheckOriginToMoveCard(Stadium, "Your Stadium Spot","Which would you like to add to your Prize Cards?", Input, PrizeCards, "Your Prize Cards");
                            break;
                        } else if (CardTo.toLowerCase().equals("hand")) {
                            CheckOriginToMoveCard(Stadium, "Your Stadium Spot","Which would you like to add to your Stadium Spot?", Input, Hand, "Your Hand");
                            break;
                        }else{
                            System.out.println("Not a valid location");
                        }
                    }
                }
            } else if (NextMove.toLowerCase().equals("movepokemon")) {
                System.out.println("Where would you like to move the card from? (Hand, Deck, Discard, Active, Bench)");
                String PokemonFrom = Input.next();
                while(true){
                    if(PokemonFrom.toLowerCase().equals("hand")){
                        System.out.println("Where would you like to move the card to? (Active or Bench)" );
                        String PokemonTo = Input.next();
                        if(PokemonTo.toLowerCase().equals("active")){
                            while(true) {
                                PrintList(Hand, "Your Hand");
                                System.out.println("Which Pokemon would you like to move?");
                                int CardFromHandToActive = Input.nextInt();
                                if(CardFromHandToActive<= Hand.size()){
                                    MovePokemonIntoPlay(Hand,CardFromHandToActive,Active,"Your Active Spot",true,PokemonEvolvesFrom,MaxBenchSize,AttachedCards);
                                    break;
                                } else if (CardFromHandToActive==420) {
                                    break;
                                }else{
                                    System.out.println("You don't have that card.");
                                    continue;
                                }
                            }
                            break;
                        } else if (PokemonTo.toLowerCase().equals("bench")) {
                            while(true) {
                                PrintList(Hand, "Your Hand");
                                System.out.println("Which Pokemon would you like to move?");
                                int CardFromHandToBench = Input.nextInt();
                                if(CardFromHandToBench<= Hand.size()){
                                    MovePokemonIntoPlay(Hand,CardFromHandToBench,Bench,"Your Bench",false,PokemonEvolvesFrom,MaxBenchSize,AttachedCards);
                                    break;
                                } else if (CardFromHandToBench==420) {
                                    break;
                                }else{
                                    System.out.println("You don't have that card.");
                                    continue;
                                }
                            }
                            break;
                        }else{
                            System.out.println("That was not a valid location.");
                            continue;
                        }
                    } else if (PokemonFrom.toLowerCase().equals("deck")) {
                        System.out.println("Where would you like to move the card to? (Active or Bench)" );
                        String PokemonTo = Input.next();
                        if(PokemonTo.toLowerCase().equals("active")){
                            while(true) {
                                System.out.println("There are "+DeckFront.size()+" at the Front, "+Deck.size()+" in the deck, "+DeckBack.size()+" at the bottom.");
                                PrintDeck(DeckFront,Deck,DeckBack);
                                System.out.println("Which Pokemon would you like to move?");
                                int CardFromHandToActive = Input.nextInt();
                                int CardFromDeckToActive = CardFromHandToActive- DeckFront.size();
                                int CardFromDeckBackToActive = CardFromDeckToActive-Deck.size();
                                if(CardFromHandToActive<=DeckFront.size()){
                                    MovePokemonIntoPlay(DeckFront,CardFromHandToActive,Active,"Your Active Spot",true,PokemonEvolvesFrom,MaxBenchSize,AttachedCards);
                                    break;
                                }else if(CardFromDeckToActive<= Deck.size()){
                                    MovePokemonIntoPlay(Deck,CardFromDeckToActive,Active,"Your Active Spot",true,PokemonEvolvesFrom,MaxBenchSize,AttachedCards);
                                    break;
                                }else if(CardFromDeckBackToActive<= DeckBack.size()) {
                                    MovePokemonIntoPlay(Deck, CardFromDeckBackToActive, Active, "Your Active Spot", true, PokemonEvolvesFrom, MaxBenchSize, AttachedCards);
                                    break;
                                }else if (CardFromHandToActive==420) {
                                    break;
                                }else{
                                    System.out.println("You don't have that card.");
                                    continue;
                                }
                            }
                            break;
                        } else if (PokemonTo.toLowerCase().equals("bench")) {
                            while(true) {
                                PrintList(Deck, "Your Deck");
                                System.out.println("Which Pokemon would you like to move?");
                                int CardFromDeckFrontToBench = Input.nextInt();
                                int CardFromDeckToBench = CardFromDeckFrontToBench- DeckFront.size();
                                int CardFromDeckBackToBench = CardFromDeckToBench-Deck.size();
                                if(CardFromDeckFrontToBench<= DeckFront.size()){
                                    MovePokemonIntoPlay(Deck,CardFromDeckFrontToBench,Bench,"Your Bench",false,PokemonEvolvesFrom,MaxBenchSize,AttachedCards);
                                    break;
                                } else if(CardFromDeckToBench<= Deck.size()){
                                    MovePokemonIntoPlay(Deck,CardFromDeckToBench,Bench,"Your Bench",false,PokemonEvolvesFrom,MaxBenchSize,AttachedCards);
                                    break;
                                }else if(CardFromDeckBackToBench<= DeckBack.size()){
                                    MovePokemonIntoPlay(Deck,CardFromDeckBackToBench,Bench,"Your Bench",false,PokemonEvolvesFrom,MaxBenchSize,AttachedCards);
                                    break;
                                }else if (CardFromDeckFrontToBench==420) {
                                    break;
                                }else{
                                    System.out.println("You don't have that card.");
                                    continue;
                                }
                            }
                            break;
                        }else{
                            System.out.println("That was not a valid location.");
                            continue;
                        }
                    } else if (PokemonFrom.toLowerCase().equals("discard")) {
                        System.out.println("Where would you like to move the card to? (Active or Bench)" );
                        String PokemonTo = Input.next();
                        if(PokemonTo.toLowerCase().equals("active")){
                            while(true) {
                                PrintList(Discard, "Your Discard Pile");
                                System.out.println("Which Pokemon would you like to move?");
                                int CardFromHandToActive = Input.nextInt();
                                if(CardFromHandToActive<= Discard.size()){
                                    MovePokemonIntoPlay(Discard,CardFromHandToActive,Active,"Your Active Spot",true,PokemonEvolvesFrom,MaxBenchSize,AttachedCards);
                                    break;
                                } else if (CardFromHandToActive==420) {
                                    break;
                                }else{
                                    System.out.println("You don't have that card.");
                                    continue;
                                }
                            }
                            break;
                        } else if (PokemonTo.toLowerCase().equals("bench")) {
                            while(true) {
                                PrintList(Discard, "Your Discard Pile");
                                System.out.println("Which Pokemon would you like to move?");
                                int CardFromHandToBench = Input.nextInt();
                                if(CardFromHandToBench<= Discard.size()){
                                    MovePokemonIntoPlay(Discard,CardFromHandToBench,Bench,"Your Bench",false,PokemonEvolvesFrom,MaxBenchSize,AttachedCards);
                                    break;
                                } else if (CardFromHandToBench==420) {
                                    break;
                                }else{
                                    System.out.println("You don't have that card.");
                                    continue;
                                }
                            }
                            break;
                        }else{
                            System.out.println("That was not a valid location.");
                            continue;
                        }
                    } else if (PokemonFrom.toLowerCase().equals("active")) {
                        System.out.println("Where would you like to move the card to? (Hand, Deck, Discard, or Bench)");
                        String PokemonTo = Input.next();
                        if (PokemonTo.toLowerCase().equals("hand")) {
                            MovePokemonOutOfPlay(Active, Hand, "Your Hand", AttachedCards, 0);
                        } else if (PokemonTo.toLowerCase().equals("deck")) {
                            while (true) {
                                System.out.println("Where in the deck would you like to move it? (Front, Deck, Back, or Return");
                                String DeckPlacement = Input.next();
                                if (DeckPlacement.toLowerCase().equals("front")) {
                                    MovePokemonOutOfPlay(Active, DeckFront, "the Front of Your Deck", AttachedCards, 0);
                                    break;
                                } else if (DeckPlacement.toLowerCase().equals("deck")) {
                                    MovePokemonOutOfPlay(Active, Deck, "Your Deck", AttachedCards, 0);
                                    break;
                                } else if (DeckPlacement.toLowerCase().equals("back")) {
                                    MovePokemonOutOfPlay(Active, DeckBack, "the Bottom of Your Deck", AttachedCards, 0);
                                    break;
                                } else if (DeckPlacement.toLowerCase().equals("return")) {
                                    break;
                                } else {
                                    System.out.println("That is not a valid location!");
                                }
                            }
                        } else if (PokemonTo.toLowerCase().equals("discard")) {
                            MovePokemonOutOfPlay(Active, Discard, "Your Discard Pile", AttachedCards, 0);
                        } else if (PokemonTo.toLowerCase().equals("bench")){
                            PrintList(Bench,"Your Bench");
                            while(true){
                                System.out.println("Which would you like to move?");
                                int ReplaceActive = Input.nextInt();
                                if (ReplaceActive<=Bench.size()){
                                    MoveCard(Active,Bench,"Your Bench",1);
                                    MoveCard(Bench,Active,"Your Active Spot",ReplaceActive);
                                    break;
                                } else if (ReplaceActive==420) {
                                    break;
                                }else{
                                    System.out.println("You don't have a pokemon there.");
                                }
                            }
                            break;
                        } else {
                            System.out.println("That was not a valid location!");
                            continue;
                        }
                        while (true) {
                            if (Bench.isEmpty()){
                                System.out.println("You have no pokemon on your bench. You have lost the game");
                                break;
                            }
                            PrintList(Bench,"Your Bench");
                            System.out.println("Which Bench should replace your active?");
                            int ActiveReplace = Input.nextInt();
                            int NewActiveIndex = ActiveReplace-1;
                            if(ActiveReplace<=Bench.size()){
                                MoveCard(Bench,Active,"Your Active Spot",ActiveReplace);
                                break;
                            } else if (ActiveReplace==420) {
                                break;
                            }else {
                                System.out.println("There isn't a pokemon in that spot.");
                            }
                        }
                        break;
                    } else if (PokemonFrom.toLowerCase().equals("bench")) {
                        while (true) {
                            PrintList(Bench, "Your Bench");
                            System.out.println("Which pokemon would you like to move?");
                            int BenchPokemontoMove = Input.nextInt();
                            int BenchPokemonIndex = BenchPokemontoMove-1;
                            if(BenchPokemontoMove<=Bench.size()){
                                System.out.println("Where would you like to move the card to? (Hand, Deck, Discard, or Return)");
                                String PokemonTo = Input.next();
                                if(PokemonTo.toLowerCase().equals("hand")){
                                    MovePokemonOutOfPlay(Bench,Hand,"Your Hand",AttachedCards,BenchPokemonIndex);
                                    break;
                                }else if(PokemonTo.toLowerCase().equals("deck")) {
                                    while (true){
                                        System.out.println("Where in the deck would you like to move it? (Front, Deck, Back, or Return");
                                        String DeckPlacement = Input.next();
                                        if(DeckPlacement.toLowerCase().equals("front")){
                                            MovePokemonOutOfPlay(Bench, DeckFront, "the Front of Your Deck", AttachedCards, BenchPokemonIndex);
                                            break;
                                        }else if(DeckPlacement.toLowerCase().equals("deck")){
                                            MovePokemonOutOfPlay(Bench, Deck, "Your Deck", AttachedCards, BenchPokemonIndex);
                                            break;
                                        }else if(DeckPlacement.toLowerCase().equals("back")){
                                            MovePokemonOutOfPlay(Bench, DeckBack, "the Bottom of Your Deck", AttachedCards, BenchPokemonIndex);
                                            break;
                                        } else if (DeckPlacement.toLowerCase().equals("return")) {
                                            break;
                                        }else{
                                            System.out.println("That is not a valid location!");
                                        }
                                    }
                                    break;
                                }else if(PokemonTo.toLowerCase().equals("discard")){
                                    MovePokemonOutOfPlay(Bench,Discard,"Your Discard Pile",AttachedCards,BenchPokemonIndex);
                                    break;
                                }else if(PokemonTo.toLowerCase().equals("return")){
                                    break;
                                }else{
                                    System.out.println("That is not a valid location!");
                                }
                            }else if (BenchPokemontoMove==420){
                                break;
                            }else{
                                System.out.println("There's not a pokemon there");
                            }
                        }
                        break;
                    }else{
                        System.out.println("Not a valid origin");
                        break;
                    }
                }
            }if(NextMove.equalsIgnoreCase("attachcard")){
                while (true) {
                    System.out.println("Would you like to Attach or Detach a card? (return to go back)");
                    String AttachOrDetach = Input.next();
                    if(AttachOrDetach.equalsIgnoreCase("attach")){
                        System.out.println("Where would you like to take the card from? (Hand, Deck, Discard, or Return)");
                        String TakeCardFromToAttach = Input.next();
                        System.out.println("Where would you like to attach the card to? (Active, Discard, or Return");
                        String LocationToAttachTo = Input.next();
                        if(TakeCardFromToAttach.equalsIgnoreCase("hand")){
                            if(LocationToAttachTo.equalsIgnoreCase("active")){
                                CheckBooleanToAttachCard(Input,Hand,"Your Hand",Active,"Your Active",true,IsEnergyOrTool,AttachedCards);
                            } else if (LocationToAttachTo.equalsIgnoreCase("bench")) {
                                CheckBooleanToAttachCard(Input,Hand,"Your Hand",Bench,"Your Bench",false,IsEnergyOrTool,AttachedCards);
                            } else if (LocationToAttachTo.equalsIgnoreCase("return")) {
                               break;
                            }else{
                                System.out.println("That's not a valid location to attach a card to.");
                            }
                        } else if (TakeCardFromToAttach.equalsIgnoreCase("deck")) {
                            if(LocationToAttachTo.equalsIgnoreCase("active")){
                                PrintDeck(DeckFront,Deck,DeckBack);
                                System.out.println("Which Card would you like to move from the deck");
                                int CardToAttachFromDeck = Input.nextInt();
                                CheckBooleanToTakeFromDeckSpecific(DeckFront, Deck, DeckBack, AttachedCards.get(Active.get(0)), "Your Active", CardToAttachFromDeck, IsEnergyOrTool);
                                break;
                            } else if (LocationToAttachTo.equalsIgnoreCase("bench")) {
                                PrintDeck(DeckFront,Deck,DeckBack);
                                System.out.println("Which Card would you like to move from the deck?");
                                int CardToAttachFromDeckToBench = Input.nextInt();
                                PrintList(Bench,"Your Bench");
                                System.out.println("And where would you like to move it to?");
                                int BenchToAttachCard = Input.nextInt();
                                if(BenchToAttachCard<=Bench.size()) {
                                    CheckBooleanToTakeFromDeckSpecific(DeckFront, Deck, DeckBack, AttachedCards.get(Bench.get(BenchToAttachCard-1)), "Your Active", CardToAttachFromDeckToBench, IsEnergyOrTool);
                                    break;
                                }else{
                                    System.out.println("There isn't a Pokemon there.");
                                }
                            } else if (LocationToAttachTo.equalsIgnoreCase("return")) {
                                break;
                            }else{
                                System.out.println("That's not a valid location to attach a card to.");
                            }
                        } else if (TakeCardFromToAttach.equalsIgnoreCase("discard")) {
                            if(LocationToAttachTo.equalsIgnoreCase("active")){
                                CheckBooleanToAttachCard(Input,Discard,"Your Discard Pile",Active,"Your Active",true,IsEnergyOrTool,AttachedCards);
                                break;
                            } else if (LocationToAttachTo.equalsIgnoreCase("discard")) {
                                CheckBooleanToAttachCard(Input,Discard,"Your Discard Pile",Bench,"Your Bench",false,IsEnergyOrTool,AttachedCards);
                                break;
                            } else if (LocationToAttachTo.equalsIgnoreCase("return")) {
                                break;
                            }else{
                                System.out.println("That's not a valid location to attach a card to.");
                            }
                        } else if (TakeCardFromToAttach.equalsIgnoreCase("return")) {
                            break;
                        }else{
                            System.out.println("Not a valid take from location");
                        }
                    } else if (AttachOrDetach.equalsIgnoreCase("detach")) {
                        System.out.println("Where would you like to take the card from? (Active, Bench, or Return)");
                        String TakeCardFromToDetach = Input.next();
                        System.out.println("Where would you like to attach the card to? (Hand, Deck, Discard, or Return");
                        String LocationToAttachTo = Input.next();
                        if(TakeCardFromToDetach.equalsIgnoreCase("active")){
                            if(LocationToAttachTo.equalsIgnoreCase("hand")){
                                while(true){
                                    PrintList(AttachedCards.get(Active.get(0)),Active.get(0));
                                    System.out.println("Which Card would you like to move?");
                                    int CardToRemoveFromActive = Input.nextInt();
                                    if(CardToRemoveFromActive<=AttachedCards.get(Active.get(0)).size()){
                                        MoveCard(AttachedCards.get(Active.get(0)),Hand,"Your Hand",CardToRemoveFromActive);
                                        break;
                                    } else if (CardToRemoveFromActive==420) {
                                        break;
                                    }else{
                                        System.out.println(Active.get(0)+" doesn't have that card.");
                                    }
                                }
                            } else if (LocationToAttachTo.equalsIgnoreCase("Deck")) {
                                while (true) {
                                    System.out.println("Where would you like to move the card in the deck? (Front, Deck, Bottom, or Return)");
                                    String LocationInDeck = Input.next();
                                    if (LocationInDeck.equalsIgnoreCase("front")){
                                        PrintList(AttachedCards.get(Active.get(0)),Active.get(0));
                                        System.out.println("Which Card would you like to move?");
                                        int CardToRemoveFromActive = Input.nextInt();
                                        if(CardToRemoveFromActive<=AttachedCards.get(Active.get(0)).size()) {
                                            MoveCard(AttachedCards.get(Active.get(0)), DeckFront, "Front of Your Deck", CardToRemoveFromActive);
                                            break;
                                        }else if (CardToRemoveFromActive==420) {
                                            break;
                                        }else{
                                            System.out.println(Active.get(0)+" doesn't have that card.");
                                        }
                                    } else if (LocationInDeck.equalsIgnoreCase("deck")){
                                        PrintList(AttachedCards.get(Active.get(0)),Active.get(0));
                                        System.out.println("Which Card would you like to move?");
                                        int CardToRemoveFromActive = Input.nextInt();
                                        if(CardToRemoveFromActive<=AttachedCards.get(Active.get(0)).size()) {
                                            MoveCard(AttachedCards.get(Active.get(0)), Deck, "Your Deck", CardToRemoveFromActive);
                                            break;
                                        }else if (CardToRemoveFromActive==420) {
                                            break;
                                        }else{
                                            System.out.println(Active.get(0)+" doesn't have that card.");
                                        }
                                    } else if (LocationInDeck.equalsIgnoreCase("bottom")){
                                        PrintList(AttachedCards.get(Active.get(0)),Active.get(0));
                                        System.out.println("Which Card would you like to move?");
                                        int CardToRemoveFromActive = Input.nextInt();
                                        if(CardToRemoveFromActive<=AttachedCards.get(Active.get(0)).size()) {
                                            MoveCard(AttachedCards.get(Active.get(0)), DeckBack, "Back of Your Deck", CardToRemoveFromActive);
                                            break;
                                        }else if (CardToRemoveFromActive==420) {
                                            break;
                                        }else{
                                            System.out.println(Active.get(0)+" doesn't have that card.");
                                        }
                                    }else if (LocationInDeck.equalsIgnoreCase("return")){
                                        break;
                                    }else{
                                        System.out.println("That's not a location in the deck.");
                                    }
                                }
                            } else if(LocationToAttachTo.equalsIgnoreCase("discard")){
                                while(true){
                                    PrintList(AttachedCards.get(Active.get(0)),Active.get(0));
                                    System.out.println("Which Card would you like to move?");
                                    int CardToRemoveFromActive = Input.nextInt();
                                    if(CardToRemoveFromActive<=AttachedCards.get(Active.get(0)).size()){
                                        MoveCard(AttachedCards.get(Active.get(0)),Discard,"Your Discard Pile", CardToRemoveFromActive);
                                        break;
                                    } else if (CardToRemoveFromActive==420) {
                                        break;
                                    } else {
                                        System.out.println(Active.get(0)+" doesn't have that card.");
                                    }
                                }
                            } else if (LocationToAttachTo.equalsIgnoreCase("return")) {
                                break;
                            } else{
                                System.out.println("Not a valid move location.");
                            }
                        } else if (TakeCardFromToDetach.equalsIgnoreCase("bench")) {
                            while(true){
                                PrintList(Bench,"Your Bench");
                                System.out.println("Which Pokemon would you like to remove a card from?");
                                int ChooseBenchToRemoveFrom = Input.nextInt();
                                int ChooseBenchToRemoveFromIndex = ChooseBenchToRemoveFrom-1;
                                if(ChooseBenchToRemoveFrom<=Bench.size()){
                                    while(true){
                                        PrintList(AttachedCards.get(Bench.get(ChooseBenchToRemoveFromIndex)), Bench.get(ChooseBenchToRemoveFromIndex));
                                        System.out.println("Which Card would you like to remove.");
                                        int CardToRemoveFromBench = Input.nextInt();
                                        if(CardToRemoveFromBench<= AttachedCards.get(Bench.get(ChooseBenchToRemoveFromIndex)).size()){
                                            if(LocationToAttachTo.equalsIgnoreCase("Hand")){
                                               MoveCard(AttachedCards.get(Bench.get(ChooseBenchToRemoveFromIndex)),Hand,"Your Hand",CardToRemoveFromBench);
                                            } else if (LocationToAttachTo.equalsIgnoreCase("Discard")) {
                                                MoveCard(AttachedCards.get(Bench.get(ChooseBenchToRemoveFromIndex)),Discard,"Your Discard Pile",CardToRemoveFromBench);
                                            } else if (LocationToAttachTo.equalsIgnoreCase("Deck")) {
                                                while (true) {
                                                    System.out.println("Where would you like to move the card in the deck? (Front, Deck, Bottom, or Return)");
                                                    String LocationInDeck = Input.next();
                                                    if (LocationInDeck.equalsIgnoreCase("front")){
                                                        MoveCard(AttachedCards.get(Bench.get(ChooseBenchToRemoveFromIndex)), DeckFront, "Front of Your Deck", CardToRemoveFromBench);
                                                        break;
                                                    } else if (LocationInDeck.equalsIgnoreCase("deck")){
                                                        MoveCard(AttachedCards.get(Bench.get(ChooseBenchToRemoveFromIndex)), Deck, "Your Deck", CardToRemoveFromBench);
                                                        break;
                                                    } else if (LocationInDeck.equalsIgnoreCase("bottom")){
                                                        MoveCard(AttachedCards.get(Bench.get(ChooseBenchToRemoveFromIndex)), DeckBack, "Back of Your Deck", CardToRemoveFromBench);
                                                        break;
                                                    }else if (LocationInDeck.equalsIgnoreCase("return")){
                                                        break;
                                                    }else{
                                                        System.out.println("That's not a location in the deck.");
                                                    }
                                                }
                                            }
                                            break;
                                        } else if (CardToRemoveFromBench==420) {
                                            break;
                                        }else{
                                            System.out.println("That Pokemon does not have that card.");
                                        }
                                    }
                                    break;
                                } else if (ChooseBenchToRemoveFrom==420) {
                                    break;
                                }else {
                                    System.out.println("There is no Pokemon there.");
                                }
                            }
                        }
                    } else if (AttachOrDetach.equalsIgnoreCase("return")) {
                       break;
                    }else{
                        System.out.println("That's not a valid command");
                    }
                }
            }if(NextMove.equalsIgnoreCase("changestatus")){
                while (true){
                    System.out.println("Choose which setting you would like to change:");
                    System.out.println("1) Prize Cards Revealed: "+PrizeCardsRevealed);
                    System.out.println("2) Max Bench Size: "+MaxBenchSize);
                    int ChangeStatusChoice = Input.nextInt();
                    if(ChangeStatusChoice==1){
                        System.out.println("This setting is currently set to: "+PrizeCardsRevealed);
                        System.out.println("Would you like to set it to "+!PrizeCardsRevealed+"? (Y or N)");
                        String ChangeRevealed = Input.next();
                        if(ChangeRevealed.equalsIgnoreCase("y")){
                            PrizeCardsRevealed = !PrizeCardsRevealed;
                            break;
                        } else if (ChangeRevealed.equalsIgnoreCase("n")) {
                            System.out.println("Understandable, Have a nice day.");
                            break;
                        }else{
                            System.out.println("Bruh you had 2 options: Y or N. Try Harder next time.");
                        }
                    }else if(ChangeStatusChoice==2) {
                        System.out.println("Your Max Bench size is currently set to "+MaxBenchSize+".");
                        System.out.println("What amount would you like to set it to?");
                        MaxBenchSize = Input.nextInt();
                        if(MaxBenchSize<Bench.size()) {
                            while (MaxBenchSize<Bench.size()) {
                                int AmountLeft = Bench.size()-MaxBenchSize;
                                PrintList(Bench, "Your Bench");
                                System.out.println("You have "+AmountLeft+" to remove left. Which would you like to remove?");
                                int BenchToRemove = Input.nextInt();
                                int BenchToRemoveIndex = BenchToRemove-1;
                                MovePokemonOutOfPlay(Bench,Discard,"Your Discard Pile",AttachedCards,BenchToRemoveIndex);
                            }
                        }
                        System.out.println("Max Bench Size was changed to: "+MaxBenchSize);
                        break;
                    }
                }
            }
            System.out.println();
            System.out.println("Here is Your Hand!");
            PrintList(Hand,"Your Hand");
            System.out.println();
            int TotalCardsInDeck=DeckFront.size()+Deck.size()+DeckBack.size();
            String DiscardIcon;
            if(Discard.size()==0){
                DiscardIcon="0";
            } else if (Discard.size()==1) {
                DiscardIcon=Discard.get(0);
            } else{
                int DiscardIconGet=Discard.size()-1;
                DiscardIcon=Discard.get(DiscardIconGet)+" (+"+DiscardIconGet+")";
            }
            if(Stadium.size()==0){
                StadiumDisplay = "EMPTY";
            }else{
                StadiumDisplay = Stadium.get(0);
            }
            System.out.println("Stadium> ["+StadiumDisplay+"] ["+PrizeCards.size()+"] <Prize Cards    Deck> ["+TotalCardsInDeck+"] ["+DiscardIcon+"] <Discard Pile");
            PrintActiveAndBench(Active,Bench,PokemonNickname,MaxBenchSize,AttachedCards);
        }
    }

    private static void CheckBooleanToAttachCard(Scanner Input, List<String> Origin, String OriginName, List<String> Destination, String DestinationName,Boolean DestinationIsActive, Map<String, Boolean> TestBoolean, Map<String, List<String>> AttachedCards) {
        if (DestinationIsActive) {
            while (true) {
                PrintList(Origin, OriginName);
                System.out.println("Which card would you like to move?");
                int CardFromOriginToActive = Input.nextInt();
                int CardFromOriginToActiveIndex = CardFromOriginToActive - 1;
                if (CardFromOriginToActive <= Origin.size()) {
                    if (TestBoolean.getOrDefault(Origin.get(CardFromOriginToActiveIndex), false).equals(true)) {
                        MoveCard(Origin, AttachedCards.get(Destination.get(0)), DestinationName, CardFromOriginToActive);
                        break;
                    }
                } else if (CardFromOriginToActive == 420) {
                    break;
                } else {
                    System.out.println("You don't have that card.");
                }
            }
        }else{
            while (true) {
                PrintList(Origin, OriginName);
                System.out.println("Which card would you like to move?");
                int CardFromOriginToBench = Input.nextInt();
                int CardFromOriginToBenchIndex = CardFromOriginToBench - 1;
                PrintList(Destination, DestinationName);
                System.out.println("Which card would you like to move it to?");
                int CardOnBench = Input.nextInt();
                int CardOnBenchIndex = CardOnBench - 1;
                if(CardOnBench<=Destination.size()) {
                    if (CardFromOriginToBench <= Origin.size()) {
                        if (TestBoolean.getOrDefault(Origin.get(CardFromOriginToBenchIndex), false).equals(true)) {
                            MoveCard(Origin, AttachedCards.get(Destination.get(CardOnBenchIndex)), DestinationName, CardFromOriginToBench);
                            break;
                        }
                    } else if (CardFromOriginToBench == 420) {
                        break;
                    } else {
                        System.out.println("You don't have that card.");
                    }
                }else if (CardOnBench== 420) {
                    break;
                } else {
                    System.out.println("There's no Card there on the bench.");
                }
            }
        }
    }

    private static void CheckBooleanToMoveCard(Scanner Input, List<String> Origin, String OriginName, Map<String, Boolean> IsBoolean,List<String> Destination, String DestinationName) {
        while(true) {
            PrintList(Origin, OriginName);
            System.out.println("Which card would you like to move to "+ DestinationName);
            int CardFromHandToPrizeCards = Input.nextInt();
            if(CardFromHandToPrizeCards<= Origin.size()){
                int StadiumCheck = CardFromHandToPrizeCards-1;
                if(IsBoolean.getOrDefault(Origin.get(StadiumCheck),false).equals(true)){
                    MoveCard(Origin, Destination, DestinationName,CardFromHandToPrizeCards);
                    break;
                }else {
                    System.out.println("That is not a Stadium Card");
                }
            } else if (CardFromHandToPrizeCards==420) {
                break;
            }else{
                System.out.println("You don't have that card.");
                continue;
            }
        }
    }

    private static void MovePokemonOutOfPlay(List<String> Origin, List<String> Destination,String DestinationName, Map<String, List<String>> AttachedCards,int CardWantedIndex) {
        int OriginalSizeOfAttachedCards=AttachedCards.get(Origin.get(CardWantedIndex)).size();
        for(int i = 0; i<OriginalSizeOfAttachedCards; i++){
            int Reverse = OriginalSizeOfAttachedCards-i;
            MoveCard(AttachedCards.get(Origin.get(CardWantedIndex)), Destination,DestinationName,Reverse);
        }
        int CardWantedPlusOne = CardWantedIndex+1;
        MoveCard(Origin, Destination,"Your Hand",CardWantedPlusOne);
    }

    private static void CheckDeckToMoveCard(Scanner Input, List<String> DeckFront, List<String> Deck, List<String> DeckBack, List<String> Destination, String DestinationName, boolean CheckForBoolean, Map<String,Boolean> CheckBoolean) {
        while(true) {
            if (CheckForBoolean){
                int DeckTotal = DeckFront.size() + Deck.size() + DeckBack.size();
                PrintDeck(DeckFront, Deck, DeckBack);
                System.out.println("Which Card would you like to add to " + DestinationName + "?");
                int CardFromDeckWanted = Input.nextInt();
                if (CardFromDeckWanted <= DeckTotal) {
                    TakeFromDeckSpecific(DeckFront, Deck, DeckBack, Destination, DestinationName, CardFromDeckWanted);
                    break;
                } else if (CardFromDeckWanted == 420) {
                    break;
                } else {
                    System.out.println("That Card is not available.");
                    continue;
                }
            }else {
                int DeckTotal = DeckFront.size() + Deck.size() + DeckBack.size();
                PrintDeck(DeckFront, Deck, DeckBack);
                System.out.println("Which Card would you like to add to " + DestinationName + "?");
                int CardFromDeckWanted = Input.nextInt();
                if (CardFromDeckWanted <= DeckTotal) {
                    TakeFromDeckSpecific(DeckFront, Deck, DeckBack, Destination, DestinationName, CardFromDeckWanted);
                    break;
                } else if (CardFromDeckWanted == 420) {
                    break;
                } else {
                    System.out.println("That Card is not available.");
                    continue;
                }
            }
        }
    }

    private static void CheckOriginToMoveCard(List<String> Origin, String OriginName, String MoveQuestion, Scanner Input, List<String> Destination, String DestinationName) {
        while(true) {
            PrintList(Origin, OriginName);
            System.out.println(MoveQuestion);
            int CardFromHandToPrizeCards = Input.nextInt();
            if(CardFromHandToPrizeCards<= Origin.size()){
                MoveCard(Origin, Destination, DestinationName,CardFromHandToPrizeCards);
                break;
            } else if (CardFromHandToPrizeCards==420) {
                break;
            }else{
                System.out.println("You don't have that card.");
                continue;
            }
        }
    }

    private static void PsychicGLCRegister(List<String> Deck, Map<String, String> PokemonNickname, Map<String, List<String>> AttachedCards, Map<String,String> PokemonEvolvesFrom, Map<String,Boolean> IsStadium, Map<String,Boolean> IsToolOrEnergy) {
        int X;
        Deck.add("Brock's Grit (S)");
        Deck.add("Peonia (S)");
        Deck.add("Big Parasol");
        X=Deck.size()-1;
        IsToolOrEnergy.put(Deck.get(X),true);
        Deck.add("Capture Energy");
        X=Deck.size()-1;
        IsToolOrEnergy.put(Deck.get(X),true);
        Deck.add("Counter Catcher (I)");
        Deck.add("Pal Pad (I)");
        Deck.add("Switch Cart (I)");
        Deck.add("Oricorio");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Ori");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        Deck.add("Cosmoem");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Csmm");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Cosmog");
        Deck.add("Clefairy");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Cfy");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        Deck.add("Pokemon Fan Club (S)");
        Deck.add("Cresselia");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Crs");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        Deck.add("Rescue Stretcher (I)");
        Deck.add("Spiritomb");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Spi");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        Deck.add("Palossand");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Pal");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Sandygast");
        Deck.add("Lure Module (I)");
        Deck.add("Gladion (S)");
        Deck.add("Klara (S)");
        Deck.add("Egg Incubator (I)");
        Deck.add("Lucky Energy");
        X=Deck.size()-1;
        IsToolOrEnergy.put(Deck.get(X),true);
        Deck.add("Potion (I)");
        Deck.add("Pokemon Center Lady (S)");
        Deck.add("Mew");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Mew");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        Deck.add("Great Ball (I)");
        Deck.add("Evolution Incense (I)");
        Deck.add("Timer Ball (I)");
        Deck.add("Pokemon Catcher (I)");
        Deck.add("Professor's Letter (I)");
        Deck.add("Mesprit");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Msp");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        Deck.add("Sigilyph");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Sig");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        Deck.add("Mallow (S)");
        Deck.add("Lunala");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Lun");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Cosmoem");
        Deck.add("Poke Ball (I)");
        Deck.add("Alter of the Moone");
        X = Deck.size()-1;
        IsStadium.put(Deck.get(X),true);
        Deck.add("Galarian Rapidash");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"G Rap");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Galarian Ponyta");
        Deck.add("Clefable");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Cfb");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Clefairy");
        Deck.add("Cosmog");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Csmg");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        Deck.add("Sandygast");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Sang");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        Deck.add("Horror Energy");
        X=Deck.size()-1;
        IsToolOrEnergy.put(Deck.get(X),true);
        Deck.add("Galarian Ponyta");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"G Pon");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        Deck.add("Mewtwo");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Mew2");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        Deck.add("Gengar");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Geng");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Haunter");
        Deck.add("Mystery Energy");
        X=Deck.size()-1;
        IsToolOrEnergy.put(Deck.get(X),true);
        Deck.add("Energy Retrieval (I)");
        Deck.add("Cook (S)");
        Deck.add("Haunter");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Hant");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Gastly");
        Deck.add("Rare Candy (I)");
        Deck.add("Evosoda (I)");
        Deck.add("Switch (I)");
        Deck.add("Gastly");
        X = Deck.size()-1;
        PokemonNickname.put(Deck.get(X),"Gast");
        AttachedCards.put(Deck.get(X), new ArrayList<>());
        PokemonEvolvesFrom.put(Deck.get(X),"Basic");
        for(int i = Deck.size(); i<60; i++){
            Deck.add("Psychic Energy");
        }
        X=Deck.size()-1;
        IsToolOrEnergy.put(Deck.get(X),true);
    }

    private static void MoveCard(List<String> TakenFrom, List<String> MoveTo, String DestinationName, int IndexPlus1) {
        int X = IndexPlus1 -1;
        MoveTo.add(TakenFrom.get(X));
        System.out.println(TakenFrom.get(X)+" was moved to "+ DestinationName);
        TakenFrom.remove(X);
    }

    private static void HardShuffleDeck(List<String> DeckFront, List<String> DeckBack, List<String> Deck) {
        int DeckPlusBack = Deck.size()+ DeckBack.size();
        for(int i=0;i<DeckPlusBack;i++){
            if(Deck.size()>0){
                DeckFront.add(Deck.get(0));
                Deck.remove(0);
            }else if(DeckBack.size()>0){
                DeckFront.add(DeckBack.get(0));
                DeckBack.remove(0);
            }
        }
        int DeckFrontSize = DeckFront.size();
        for(int x = 0; x< DeckFrontSize; x++){
            int Random = ThreadLocalRandom.current().nextInt(0, DeckFront.size());
            Deck.add(DeckFront.get(Random));
            DeckFront.remove(Random);
        }
    }

    private static void PrintDeck(List<String> DeckFront, List<String> Deck, List<String> DeckBack) {
        int TotalCardsInDeck = DeckFront.size()+ Deck.size()+ DeckBack.size();
        int CardInFrontAndDeck = DeckFront.size()+ Deck.size();
        for(int i=0;i<TotalCardsInDeck;i++){
            if(i<DeckFront.size()){
                int Y = i + 1;
                int X = DeckFront.size()-Y;
                System.out.println(Y+": "+ DeckFront.get(X));
            } else if (i<CardInFrontAndDeck) {
                int X = i - DeckFront.size();
                int Y = i + 1;
                System.out.println(Y + ": " + Deck.get(X));
            } else if (i<TotalCardsInDeck) {
                int X = i - DeckFront.size() - Deck.size();
                int Y = i + 1;
                System.out.println(Y + ": " + DeckBack.get(X));
            }
        }
    }private static void PrintDeckLimited(List<String> DeckFront, List<String> Deck, List<String> DeckBack, int TotalToSee) {
        int TotalCardsInDeck = DeckFront.size()+ Deck.size()+ DeckBack.size();
        int CardInFrontAndDeck = DeckFront.size()+ Deck.size();
        for(int i=0;i<TotalToSee;i++){
            if(i<DeckFront.size()){
                int Y = i + 1;
                int X = DeckFront.size()-Y;
                System.out.println(Y+": "+ DeckFront.get(X));
            } else if (i<CardInFrontAndDeck) {
                int X = i - DeckFront.size();
                int Y = i + 1;
                System.out.println(Y + ": " + Deck.get(X));
            } else if (i<TotalCardsInDeck) {
                int X = i - DeckFront.size() - Deck.size();
                int Y = i + 1;
                System.out.println(Y + ": " + DeckBack.get(X));
            }
        }
    }

    private static void TakeFromDeckSpecific(List<String> DeckFront, List<String> Deck, List<String> DeckBack, List<String> Destination, String DestinationName, int CardWanted) {
        int WantedInDeck = CardWanted - DeckFront.size();
        int WantedInBack = WantedInDeck- Deck.size();
        if(CardWanted <= DeckFront.size()){
            int SpecificCardFromFront = DeckFront.size()-CardWanted;
            Destination.add(DeckFront.get(SpecificCardFromFront));
            System.out.println(DeckFront.get(SpecificCardFromFront)+" was added to "+ DestinationName);
            DeckFront.remove(SpecificCardFromFront);
        } else if (WantedInDeck<= Deck.size()) {
            int SpecificCardFromDeck = WantedInDeck-1;
            Destination.add(Deck.get(SpecificCardFromDeck));
            System.out.println(Deck.get(SpecificCardFromDeck)+" was added to "+ DestinationName);
            Deck.remove(SpecificCardFromDeck);
        } else if (WantedInBack<= DeckBack.size()) {
            int SpecificCardFromBack = WantedInBack - 1;
            Destination.add(DeckBack.get(SpecificCardFromBack));
            System.out.println(DeckBack.get(SpecificCardFromBack) + " was added to " + DestinationName);
            DeckBack.remove(SpecificCardFromBack);
        }
    }
    private static void CheckBooleanToTakeFromDeckSpecific(List<String> DeckFront, List<String> Deck, List<String> DeckBack, List<String> Destination, String DestinationName, int CardWanted, Map<String,Boolean> CheckBoolean) {
        int WantedInDeck = CardWanted - DeckFront.size();
        int WantedInBack = WantedInDeck- Deck.size();
        if(CardWanted <= DeckFront.size()){
            int SpecificCardFromFront = DeckFront.size()-CardWanted;
            if(CheckBoolean.getOrDefault(DeckFront.get(SpecificCardFromFront),false)) {
                Destination.add(DeckFront.get(SpecificCardFromFront));
                System.out.println(DeckFront.get(SpecificCardFromFront) + " was added to " + DestinationName);
                DeckFront.remove(SpecificCardFromFront);
            }else{
                System.out.println("That's not a valid card for "+DestinationName+".");
            }
        } else if (WantedInDeck<= Deck.size()) {
            int SpecificCardFromDeck = WantedInDeck-1;
            if(CheckBoolean.getOrDefault(Deck.get(SpecificCardFromDeck),false)) {
                Destination.add(Deck.get(SpecificCardFromDeck));
                System.out.println(Deck.get(SpecificCardFromDeck) + " was added to " + DestinationName);
                Deck.remove(SpecificCardFromDeck);
            }else{
                System.out.println("That's not a valid card for "+DestinationName+".");
            }
        } else if (WantedInBack<= DeckBack.size()) {
            int SpecificCardFromBack = WantedInBack - 1;
            if(CheckBoolean.getOrDefault(DeckBack.get(SpecificCardFromBack),false)) {
                Destination.add(DeckBack.get(SpecificCardFromBack));
                System.out.println(DeckBack.get(SpecificCardFromBack) + " was added to " + DestinationName);
                DeckBack.remove(SpecificCardFromBack);
            }else{
                System.out.println("That's not a valid card for "+DestinationName+".");
            }
        }else{
            System.out.println("Not a valid location in the deck.");
        }
    }


    private static void TakeFromDeck(List<String> DeckFront, List<String> Deck, List<String> DeckBack, List<String> Destination, String DestinationName, int AmountToTake) {
        for(int i = 0; i< AmountToTake; i++){
            if(DeckFront.size()>0){
                int TopCard = DeckFront.size()-1;
                Destination.add(DeckFront.get(TopCard));
                System.out.println(DeckFront.get(TopCard)+" was added to "+DestinationName+"!");
                DeckFront.remove(TopCard);

            }else if(Deck.size()>0){
                int Random = ThreadLocalRandom.current().nextInt(0, Deck.size());
                Destination.add(Deck.get(Random));
                System.out.println(Deck.get(Random)+" was added to "+DestinationName+"!");
                Deck.remove(Random);

            }else if(DeckBack.size()>0){
                Destination.add(DeckBack.get(0));
                System.out.println(DeckBack.get(0)+" was added to "+DestinationName+"!");
                DeckBack.remove(0);
            }
        }
    }private static void TakeFromDeckSilent(List<String> DeckFront, List<String> Deck, List<String> DeckBack, List<String> Destination,String DestinationName, int AmountToTake) {
        int Count = 0;
        for(int i = 0; i< AmountToTake; i++){
            if(DeckFront.size()>0){
                int TopCard = DeckFront.size()-1;
                Destination.add(DeckFront.get(TopCard));
                DeckFront.remove(TopCard);
                Count++;

            }else if(Deck.size()>0){
                int Random = ThreadLocalRandom.current().nextInt(0, Deck.size());
                Destination.add(Deck.get(Random));
                Deck.remove(Random);
                Count++;

            }else if(DeckBack.size()>0){
                Destination.add(DeckBack.get(0));
                DeckBack.remove(0);
                Count++;
            }
        }
        switch (Count){
            case 1:
                System.out.println("A card was added to "+DestinationName);
                break;
            default:
                System.out.println(Count+" cards were added to "+DestinationName);
        }
    }

    private static void PrintList(List<String> List,String ListName) {
        System.out.println(ListName+" contains "+List.size()+" cards");
        for(int i = 0; i< List.size(); i++){
            int X=i+1;
            System.out.println(X+": "+ List.get(i));
        }
    }

    private static void PrintActiveAndBench(List<String> Active, List<String> Bench, Map<String,String> PokemonNickname, int BenchSize, Map<String,List<String>> AttachedCards) {
        System.out.print("Active: "+Active.get(0)+"   ");
        if(AttachedCards.get(Active.get(0)).size()>0) {
            System.out.print("Attached Cards -> [");
            for (int x = 1; x < AttachedCards.get(Active.get(0)).size(); x++) {
                System.out.print(AttachedCards.get(Active.get(0)).get(x-1)+", ");
            }
            int LastAttachedCard = AttachedCards.get(Active.get(0)).size()-1;
            System.out.print(AttachedCards.get(Active.get(0)).get(LastAttachedCard)+"]");
        }
        System.out.println();
        int Count=0;
        for(int i = 0; i< Bench.size(); i++) {
            if (AttachedCards.get(Bench.get(i)).size() == 0) {
                Count++;
                System.out.print("[" + PokemonNickname.get(Bench.get(i)) + "] ");
            }else{
                Count++;
                System.out.print("[" + PokemonNickname.get(Bench.get(i)) + " (+"+AttachedCards.get(Bench.get(i)).size()+")] ");
            }
        }
        for(int i=Count;i<BenchSize;i++){
            System.out.print("[ ] ");
        }
        System.out.println("");
    }
    private static void MovePokemonIntoPlay(List<String> TakeFrom, int SpecificCardPlusOne, List<String> Destination, String DestinationName,Boolean DestinationIsActive, Map<String,String> PokemonEvolvesFrom, int MaxBenchSize, Map<String,List<String>> StackedCards){
        int SpecificPokemon = SpecificCardPlusOne-1;
        String Check="Alex";
        if(Check.equals(PokemonEvolvesFrom.getOrDefault(TakeFrom.get(SpecificPokemon),"Alex"))){
            System.out.println("That is not a pokemon!");
        }else if(PokemonEvolvesFrom.get(TakeFrom.get(SpecificPokemon)).equals("Basic")){
            if(DestinationIsActive){
                switch (Destination.size()){
                    case 0:
                        MoveCard(TakeFrom,Destination,DestinationName,SpecificCardPlusOne);
                        break;
                    default:
                        System.out.println("There is a pokemon in the active spot. Please try Again!");
                        break;
                }
            }else{
                if(MaxBenchSize > Destination.size()){
                    MoveCard(TakeFrom,Destination,DestinationName,SpecificCardPlusOne);
                }else{
                    System.out.println("There is no room available on the bench. Please try again!");
                }
            }
        } else if (DestinationIsActive) {
            if(Destination.size()>0) {
                if (PokemonEvolvesFrom.get(TakeFrom.get(SpecificPokemon)).equals(Destination.get(0))) {
                    StackedCards.get(TakeFrom.get(SpecificPokemon)).add(Destination.get(0));
                    System.out.println(Destination.get(0) + " has evolved into " + TakeFrom.get(SpecificPokemon));
                    int AmountOfAttachedCards =StackedCards.get((Destination.get(0))).size();
                    for (int i = 0; i < AmountOfAttachedCards; i++) {
                        StackedCards.get(TakeFrom.get(SpecificPokemon)).add(StackedCards.get(Destination.get(0)).get(0));
                        StackedCards.get(Destination.get(0)).remove(0);
                    }
                    Destination.remove(0);
                    MoveCard(TakeFrom, Destination, "Your Active Spot", SpecificCardPlusOne);
                } else {
                    System.out.println("This pokemon could not be put onto the bench.");
                }
            }else{
                System.out.println("This pokemon could not be placed onto Your Active.");
            }

        }else{
            if(Destination.size()>0) {
                int PokemonChecked = 0;
                for (int i = 0; i < Destination.size(); i++) {
                    if (PokemonEvolvesFrom.get(TakeFrom.get(SpecificPokemon)).equals(Destination.get(i))) {
                        StackedCards.get(TakeFrom.get(SpecificPokemon)).add(Destination.get(i));
                        System.out.println(Destination.get(i) + " has evolved into " + TakeFrom.get(SpecificPokemon));
                        int CardsAttachedToBench = StackedCards.get(Destination.get(i)).size();
                        for (int x = 0; x < CardsAttachedToBench; x++) {
                            StackedCards.get(TakeFrom.get(SpecificPokemon)).add(StackedCards.get(Destination.get(i)).get(0));
                            StackedCards.get(Destination.get(i)).remove(0);
                        }
                        Destination.remove(i);
                        MoveCard(TakeFrom, Destination, "Your Active Spot", SpecificCardPlusOne);
                    } else {
                        PokemonChecked++;
                        if (PokemonChecked==Destination.size()){
                            System.out.println("That Pokemon could not be played onto Your Bench");
                        }
                    }
                }
            }else{
                System.out.println("This pokemon could not be placed onto Your Bench.");
            }
        }
    }
    // Plug in Code above here by pressing on the close bracket and pressing enter to start a new line :)
}
