from network import start
from network import printdata
datas = printdata()
raws = start()

from xml.dom import minidom
import os 

root = minidom.Document()
  
xml = root.createElement('data') 
root.appendChild(xml)
#xml.setAttribute('<!--','Copyrighted Jake Leroux(c) 2021-2022 --!>')
  
firstset = root.createElement('_')
secondset = root.createElement('__')
dataset = root.createElement('internalData')

xml.appendChild(dataset)
total, start, gone = 0, 0, 0
for i in datas:
    total += 1
    new = root.createElement('value'+str(total))
    dataset.appendChild(new)
    new.setAttribute('value','{0}'.format(i))

xml.appendChild(firstset)
dov = root.createElement('internalNodes')
firstset.appendChild(dov)
for x in raws[0]:
    start += 1
    starts = root.createElement('weights1'+str(start))
    dov.appendChild(starts)
    starts.setAttribute('value','{0}'.format(x['weights']))

xml.appendChild(secondset)
gov = root.createElement('internalNodes')
secondset.appendChild(gov)
for x in raws[1]:
    gone += 1
    gones = root.createElement('weights2'+str(gone))
    gov.appendChild(gones)
    gones.setAttribute('value','{0}'.format(x['weights']))
  
xml_str = root.toprettyxml(indent= "\t") 
  
save_path_file = "autodrafter/trained.xml"
  
with open(save_path_file, "w") as f:
    f.write(xml_str) 