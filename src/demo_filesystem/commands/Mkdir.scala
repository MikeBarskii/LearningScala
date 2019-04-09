package demo_filesystem.commands

import demo_filesystem.files.{DirEntry, Directory}
import demo_filesystem.filesystem.State

class Mkdir(name: String) extends Command {

  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage("Entry " + name + " already exists!")
    } else if (name.contains(Directory.SEPARATOR)) {
      state.setMessage(name + " must not containt separators!")
    } else if (checkIllegal(name)) {
      state.setMessage(name + ": illegal entry name!")
    } else {
      doMkdir(state, name)
    }
  }

  def checkIllegal(str: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, name: String): State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      if (path.isEmpty) currentDirectory.addEntry(newEntry)
      else {
        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
        /*
          /a/b
            /c
            /d
            (new Entry)
          currentDir = /a
          path = ["b"]
         */
      }
      /*
        someDir  /a /b (new) /c => new someDir /a /b /c
        /a/b/  /c  /d  (new) /e => new /a  new /b (parent /a)
       */
    }

    val wd = state.wd

    // 1. All the directories in the full path
    val allDirsInPath = wd.getAllFoldersInPath()

    // 2. Create new directory in the the working directory(wd)
    val newDirectory = Directory.empty(wd.path, name)

    // 3. Update the whole directory structure starting from the root (the directory structure is IMMUTABLE)
    val newRoot = updateStructure(state.root, allDirsInPath, newDirectory)

    // 4. Find new working directory instance given wd's full path in the new directory structure
    val newWd = newRoot.findDescedant(allDirsInPath)

    State(newRoot, wd)
  }
}
