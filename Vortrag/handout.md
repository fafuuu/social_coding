# Hand-out zum Vortrag

## Vim

Texteditor der über verschiedene Modi verfügt.
* Insert mode - zum Schreiben von Text
* normal mode - navigieren mit `h,j,k,l` oder Textmanipulation z.B `dd` für delete line, `y`(yank) zum kopieren oder `p` zum einfügen.
* visual mode - meist für Formatierung benutzt
* command mode - `:!q` zum beenden oder `:read` zum einlesen von Dateien

## vimrc

* Vim Konfigurationsdatei
* Kann nach belieben verändert werden
* `inoremap` Remap keys in insert mode
* `nnoremap` Remap keys in normal mode
* `Autocmd Filetyp` Änderungen kommen nur bei beim spezifizierten Dateityp zum tragen.

### Beispiele
`inoremap ( ()<ESC>i` - Im insert Mode wird '(' mit '()' ausgewechselt.

`autocmd FileType java inoremap ;syso System.out.println();<ESC>ba`

Im insert Mode wird in java Dokumenten `;syso` durch die println() Funktion ersetzt

`nnoremap ;html :read /home/fabian/.vim/skeletons/skel_html.html<CR>`

Im Normal mode wird bei eingabe von `;html` ein HTML Grundgerüst eingelesen.

## Verzeichnisbaum

* Vim verfügt mit `netrw` über einen Verzeichnisbaum
```
" Tweaks for browsing
let g:netrw_banner=0        " disable annoying banner
let g:netrw_browse_split=4  " open in previous window
let g:netrw_altv=2          " open splits to the right
let g:netrw_liststyle=3     " tree view
let g:netrw_winsize = 25    " width 25%
```
Für weitere Information zu `netrw` empfehle ich [diesen](https://shapeshed.com/vim-netrw/) Blogpost.

## autocomplete

* Vim verfügt über ein simples autocomplete, leider ohne die Ergänzung von Parametern
* `ctrl + n ` - Nächster Vorschlag in der Liste
* `ctrl + p ` - vorheriger Vorschlag

### Quellen:
* Netrw: https://shapeshed.com/vim-netrw/
* Vim: http://www.vim.org
* Luke Smith:
https://www.youtube.com/channel/UC2eYFnH61tmytImy1mTYvhA/videos
* How to Do 90% of What Plugins Do (With Just Vim):
https://www.youtube.com/watch?v=XA2WjJbmmoM
