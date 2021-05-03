"""
/
PLAYER STAT GENERATOR
FYI this is very broken and doesn't work often
/
"""

require 'pathname'

path = File.expand_path("playerteam.txt")

class Sort
    def initialize(file)
        @total, @arr, @file_lines = [], [], File.readlines(file)
        @file_lines.each { |line| @arr << line.strip } and @arr.delete_at(0) and @arr.each { |item| a = item.split(" ") and @total << a }
    end
    def show
        return (@total)
    end
end

"""
/
TODO -- Overall - > Accuracy, Power, Strengh 
An Overall will be each substat added and divided by 3
Random numbers for each one so it could be 83 OVR but
Accuracy = 87, Power = 80, Strengh = 82
/
"""

class Stats
    def initialize(file)
        @overall=[] and @special=[]and @file=file and@file.each{|row|@overall<<row[3].to_i} and@file.each{|line|name=[]and name<<line[0]and name<<line[1]and(@special<<name.join(" "))} and @names = (@special)
    end
    def Depth
        i, num, @fin = 0, 12, []
        while i < num  do
            overall,nums,@start,final,send= @overall[0],[],[],[],[]
            (10.times { a = (rand(1..3)) and nums << a } and array = nums.uniq) and 3.times{ @start << overall } 
            add, sub1, sub2 = array.index { |x| [3].include?(x) }, array.index { |x| [1].include?(x) }, array.index { |x| [2].include?(x) }
            rand(1..5).times { (final << (@start[add]+3) and final << (@start[sub1]-1) and final << (@start[sub2]-2)) and @start = final and final = []}
            send<<@names[0] and send<<@start and@overall.delete_at(0) and @names.delete_at(0) and i += 1 and @fin<<send
        end
        return (@fin)
    end
end

"""
/
Saving player data
/
"""

class Saving
    def initialize(data)
        File.open("playerteam.txt", "w") { |f| data.each{|item| f.write "#{item}\n" }}
    end
end

#second = (File.expand_path(__FILE__))

begin
    10.times{Saving.new(Stats.new(Sort.new("playerteam.txt").show).Depth)}
rescue TypeError
ensure
    10.times{Saving.new(Stats.new(Sort.new("playerteam.txt").show).Depth)}
end