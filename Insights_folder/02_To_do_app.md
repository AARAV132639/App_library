# To Do App

## Version 1: No persistence
- Data cleared as app is closed

## Version 2: Persisting Data
- Data persists along with checkboxes even after app gets closed

## How the application works

### Adding

- TextField ---> taskText ---> Add button ---> tasks ---> LazyColumn

- When we execute: *tasks = tasks+ TodoTask(...)* We actually create a new list.

- Compose observes the state change adn recomposes the relevant UI

## Android Concepts

1. *@Composable*
- A composable function describes what the UI should look like for the current state

2. *remember*
- Keeps the value across recompositions
- Without it, changing the UI could cause the value to be recreated.

3. *mutableStateOf*
- This creates observable Compose state.
- Conceptually: State changes ---> Compose notices ---> Recomposition ---> UI reflects new state

4. *LazyColumn*
- This is Compose's list component.
- Unlike creating every item manually, *LazyColumn* only composes items as needed.

5. *State lifting*
- **TodoScreen** owns the task state.
- **TodoItem** doesn't own the task.

## Next Architecture

1. Persisting the data: UI ---> ViewModel ---> Repository ---> Room database ---> Persistent tasks

2. Notification based: Room ---> Incomplete tasks ---> WorkManager ---> Every 2 hours ---> Android Notifications

## Final Project Structure

ToDoApp/
|
|--MainActivity.kt
|
|-- TodoScreen.kt

|
|-- data/
|   |--TodoTask.kt
|   |-- TodoDao.kt
|   |-- TodoDatabase.kt
|   |--TodoRepository.kt
    |-- TodoViewModel.kt
    |--TodoViewModelFactory.kt

