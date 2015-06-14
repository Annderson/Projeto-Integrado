using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Projeto_Integrado_A_
{
    public partial class Teste : Form
    {
        public Teste()
        {
            InitializeComponent();
        }
        Button but = new Button();
        
        
        private void timer1_Tick(object sender, EventArgs e)
        {
            
            Random rand= new Random();
           
                int S = rand.Next(00, 99);
                
                foreach (var but in this.Controls.OfType<Button>())
                {
                    if(int.Parse(but.Text) == S)
                    {
                        but.BackColor = Color.Red;
                    }
                }
                TXTsortiados.Text = TXTsortiados.Text + S + " - ";
               
        }

        private void Sorteio_Load(object sender, EventArgs e)
        {
            IEnumerable<Button> but;
            but = this.Controls.OfType<Button>();
        }

        private void BUTstar_Click(object sender, EventArgs e)
        {
            
            timer1.Enabled = true;
        }

        private void BUTstop_Click(object sender, EventArgs e)
        {
            timer1.Enabled = false;
        }

    }
}
