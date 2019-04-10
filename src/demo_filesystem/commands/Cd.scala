package demo_filesystem.commands

import demo_filesystem.filesystem.State

class Cd(dirName: String) extends Command {
  override def apply(state: State): State = ???
}
