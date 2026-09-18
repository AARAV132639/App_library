# Calculator App

## Important points

1. *State is the heart of an interactive app*

- Information that can change while the app is running and whose change affects UI.

- Calculator: current number
- Login app: username, password, logged in status
- Todo app: list of tasks
- Music app: playing/paused, current song
- Weather app: Current data
- Chat app: Messages

2. *State ---> UI relationship*

- Compose follows a fundamental idea: State --> UI

- When state changes: State changes ---> Compose detects change ---> Recomposition ---> UI reflects new state.

- Composable takes care of updating the UI.

3. *User input is never automatically trustworth*

- The value dispalyed to the user and semantic state of the application aren't always the same thing

## Key Takeaways

1. *An app is a state machine*

- Most interactive applications can be understood as: State + Events ---> New State

2. *UI is a function of state*
- UI = f(state)

3. *Events change state*

- Flow: Tap---> onClick ---> enterNumber() ---> state changes ---> recomposition ---> new UI

4. *Reusability matters*

- Instead of repeated configuration we created : CalculatorButton(...)
- Same idea will be used for loginButton, productCard, UserCard, PostCard, Settingsitem, NavigationItem

## Android Development key concept

1. *Activity*
- An activity is an Android application component that provides a screen/context in which your UI can run

2. *@Composable*
- A composable is a function that describes UI.
- "Given the current state, describe what the UI should look like"

## Function types

1. *onClick: ()-> Unit*:
- (): takes zero arguments
- -> : function
- Unit: returns nothing meaningful

2. *ErrorHandling*: Becomes important when dealing with:
- Network
- Files
- Database
- Parsing
- User input
- APIs
- Authentication

----